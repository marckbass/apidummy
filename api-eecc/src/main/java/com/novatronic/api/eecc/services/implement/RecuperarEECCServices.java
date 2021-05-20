/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.services.implement;

import com.novatronic.api.eecc.exception.StorageException;
import com.novatronic.api.eecc.provider.azure.AzureMockProvider;
import com.novatronic.api.eecc.provider.azure.AzureProvider;

/**
 *
 * @author mrios
 */
public class RecuperarEECCServices {

    public byte[] executeService(String accountStatementId) throws StorageException {
        byte[] pdf;
        pdf = new AzureMockProvider().recuperarPDF(accountStatementId);
        return pdf;

    }

}
