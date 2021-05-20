package com.novatronic.dummy.controller;


import com.novatronic.api.eecc.bean.AccountStatementsResponse;
import com.novatronic.dummy.service.EeccService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController

//@RequestMapping("/account-statements")
public class RestController {
    private static final Logger logger = LoggerFactory.getLogger(RestController.class);
    EeccService eeccService;

    @Autowired
    public RestController(EeccService eeccService){
        this.eeccService=eeccService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = {"/account-statements"},
            produces = MediaType.APPLICATION_JSON_VALUE) //, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listadoEcc(@RequestHeader(value = "accept") final String acceptHeader,
                                             @RequestParam(value = "personId") final String personId){

        if (!acceptHeader.equals(MediaType.APPLICATION_JSON_VALUE))
            return ResponseEntity.badRequest().build();

        List<AccountStatementsResponse> lista=eeccService.getPeriods(personId);

        if (personId.isEmpty())
            return ResponseEntity.badRequest().build();

        if(lista==null || lista.isEmpty())
            return ResponseEntity
                    .notFound()
                    .build();
        else
            return ResponseEntity
                .ok()
                .header("Accept", MediaType.APPLICATION_JSON_VALUE)
                .body(lista);
    }



    /*
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

    }*/
    
    @RequestMapping(
            method = RequestMethod.GET,
            value = {"/account-statements/{idAccountStmt}"},
            produces = MediaType.APPLICATION_JSON_VALUE) //, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> downloadFile(@RequestHeader(value = "accept") final String acceptHeader,
                                                           @PathVariable final String idAccountStmt) {
        if (!acceptHeader.equals(MediaType.APPLICATION_JSON_VALUE))
            return ResponseEntity.badRequest().build();

        byte[] data = eeccService.getFinancialStatements(idAccountStmt);

        if(data==null)
            return ResponseEntity
                    .notFound()
                    .build();
        else {
            String dataBase64 = Base64.getEncoder().encodeToString(data);
            Map<String, String> map = new HashMap<>();
            map.put("statement", dataBase64);
            return ResponseEntity
                    .ok()
                    .header("Accept", MediaType.APPLICATION_JSON_VALUE)
                    .body(map);
        }
    }
}
