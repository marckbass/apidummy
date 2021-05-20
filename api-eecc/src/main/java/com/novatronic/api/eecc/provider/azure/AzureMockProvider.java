/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.provider.azure;

import com.novatronic.api.eecc.exception.StorageException;
import com.novatronic.api.eecc.provider.ServiceProvider;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrios
 */
public class AzureMockProvider implements ServiceProvider {

    @Override
    public List<String> listarPDF(String personId) throws StorageException {
        List<String> periodos = new ArrayList<>();
        if ("12345678".equals(personId)) {
            periodos.add("202101");
            periodos.add("202102");
            periodos.add("202103");
        } else {
            throw new StorageException(404, "", "PersonIdNotFound", null);
        }
        return periodos;
    }

    @Override
    public byte[] recuperarPDF(String idAccountStmt) throws StorageException {
        byte[] pdf = null;

        if ("12345678-202103".equals(idAccountStmt)) {

            try {
                Path pdfPath = Paths.get("src\\main\\resources\\12345678-202103.pdf");
                pdf = Files.readAllBytes(pdfPath);
            } catch (StorageException ex) {
                throw new StorageException(404, "", "AccountStatementIdNotFound", null);
            } catch (IOException ex) {
                Logger.getLogger(AzureMockProvider.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return pdf;
    }

}
