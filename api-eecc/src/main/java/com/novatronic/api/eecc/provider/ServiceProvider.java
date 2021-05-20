/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.provider;

import com.novatronic.api.eecc.exception.StorageException;
import java.util.List;

/**
 *
 * @author mrios
 */
public interface ServiceProvider {
    
    public byte[] recuperarPDF(String accountStatementId) throws StorageException;
    public List<String> listarPDF(String personId) throws StorageException;
    
}
