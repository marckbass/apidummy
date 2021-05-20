/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.services;

import com.novatronic.api.eecc.bean.*;
import com.novatronic.api.eecc.exception.StorageException;
import java.util.List;

/**
 *
 * @author mrios
 */
public interface ServicesEECC {

    public List<AccountStatementsResponse> listadoEECC(String personId) throws StorageException;

    public byte[] recuperarEECC(String accountStatementId) throws StorageException;
}
