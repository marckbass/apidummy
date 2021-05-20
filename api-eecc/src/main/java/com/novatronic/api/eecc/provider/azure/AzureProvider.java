/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.provider.azure;

import com.novatronic.api.eecc.provider.ServiceProvider;
import com.azure.storage.blob.models.BlobStorageException;
import com.novatronic.api.eecc.exception.StorageException;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 *
 * @author mrios
 */
public class AzureProvider implements ServiceProvider {

    @Override
    public byte[] recuperarPDF(String accountStatementId) throws StorageException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {

            if ("12345678-202103".equals(accountStatementId)) {
                AzureConfigurator.getClient("sample.pdf").download(outputStream);
                byte[] content = outputStream.toByteArray();
                return content;
            } else {
                throw new StorageException(404, "", "AccountStatementIdNotFound", null);
            }
        } catch (BlobStorageException ex) {

            throw new StorageException(ex.getStatusCode(), "", ex.getErrorCode().toString(), ex.getCause());

        }

    }

    @Override
    public List<String> listarPDF(String personId) throws StorageException {
        return new AzureMockProvider().listarPDF(personId);
    }

}
