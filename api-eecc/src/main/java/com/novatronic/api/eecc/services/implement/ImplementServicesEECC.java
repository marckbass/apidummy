/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.services.implement;

import com.novatronic.api.eecc.bean.AccountStatementsResponse;
import com.novatronic.api.eecc.exception.StorageException;
import com.novatronic.api.eecc.services.ServicesEECC;
import java.util.List;

/**
 *
 * @author mrios
 */
public class ImplementServicesEECC implements ServicesEECC {


    @Override
    public List<AccountStatementsResponse> listadoEECC(String personId) throws StorageException{
       return  new ListadoEECCServices().executeService(personId);
    }

    @Override
    public byte[] recuperarEECC(String accountStatementId) throws StorageException {
       return  new RecuperarEECCServices().executeService(accountStatementId);
    }
    
}
