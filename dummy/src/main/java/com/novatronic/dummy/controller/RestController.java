package com.novatronic.dummy.controller;


import com.novatronic.api.eecc.bean.AccountStatementsResponse;
import com.novatronic.dummy.service.EeccService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;
import java.util.List;


@org.springframework.web.bind.annotation.RestController

//@RequestMapping("/account-statements")
public class RestController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);
    EeccService eeccService;

    @Autowired
    public RestController(EeccService eeccService){
        this.eeccService=eeccService;
    }

    @GetMapping(value = {"/account-statements"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listadoEcc(@RequestParam(value = "personId",required = true) final String personId){
        List<AccountStatementsResponse> lista=eeccService.getPeriods(personId);

        if (personId.isEmpty())
            return ResponseEntity.badRequest().build();

        HttpStatus status;
        if(lista==null || lista.isEmpty()){
            return ResponseEntity
                    .notFound()
                    .build();
        } else {
            status=HttpStatus.OK;
        }
        return new ResponseEntity<Object>(lista,status);
    }
    @GetMapping(value = {"/account-statements/{idAccountStmt}"})
    public ResponseEntity <Resource> downloadFile(@PathVariable final String idAccountStmt) {
        String file="sample.pdf";
        byte[] data = eeccService.getFinancialStatements(idAccountStmt) ;
        if(data==null){
            return ResponseEntity
                    .notFound()
                    .build();
        } else {
            ByteArrayResource resource = new ByteArrayResource(data);
            return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-Transfer-Encoding", "binary")
                    .header("Content-type", "application/pdf")
                    .header("Content-disposition", "attachment; filename=\"" + file + "\"")
                    .body(resource);
        }

    }
    
    @GetMapping(value = {"/account-statements/{idAccountStmt}/base64"})
    public ResponseEntity<String> downloadFileBase64(@PathVariable final String idAccountStmt) {
        byte[] data = eeccService.getFinancialStatements(idAccountStmt);
        String dataBase64 = Base64.getEncoder().encodeToString(data);

        if(data==null)
            return ResponseEntity
                    .notFound()
                    .build();
        else
            return ResponseEntity
                    .ok()
                    .contentLength(dataBase64.length())
                    .body(dataBase64);
    }
    
}
