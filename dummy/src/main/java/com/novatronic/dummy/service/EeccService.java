package com.novatronic.dummy.service;

import com.novatronic.api.eecc.exception.StorageException;
import org.springframework.stereotype.Component;

import com.novatronic.api.eecc.bean.*;
import com.novatronic.api.eecc.services.implement.ImplementServicesEECC;

import java.util.ArrayList;
import java.util.List;

@Component
public class EeccService {

    ImplementServicesEECC service;

    public List<AccountStatementsResponse> getPeriods(String personId){
        List<AccountStatementsResponse> listadoRes= new ArrayList<>();
        try {
            listadoRes = new ImplementServicesEECC().listadoEECC(personId);
        } catch (StorageException e){

        }
        return listadoRes;
    }

    public byte[] getFinancialStatements(String idAccountStmt){
        byte[] lista = null;
        try {
            lista= new ImplementServicesEECC().recuperarEECC(idAccountStmt);
        }
        catch (StorageException e){

        }
        return  lista;
    }
    public List<AccountStatementsResponse> getAccountStatements(String personId){
        List<AccountStatementsResponse> lista1= new ArrayList<>();
        lista1.add(new AccountStatementsResponse());
        return lista1;
    }

}