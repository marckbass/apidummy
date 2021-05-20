/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.services.implement;

import com.novatronic.api.eecc.bean.*;
import com.novatronic.api.eecc.exception.StorageException;
import com.novatronic.api.eecc.provider.azure.AzureProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrios
 */
public class ListadoEECCServices {

    List<AccountStatementsResponse> executeService(String personId) throws StorageException {
        List<String> listaPeriodos;
        List<AccountStatementsResponse> listadoEECCResponses = new ArrayList<>();

        listaPeriodos = new AzureProvider().listarPDF(personId);
        listaPeriodos.stream().map((periodo) -> new AccountStatementsResponse(
                personId,
                periodo,
                getAccountStatementId(personId, periodo),
                "/account-statements/" + getAccountStatementId(personId, periodo),
                "application/json")).forEachOrdered(listadoEECCResponses::add);

        return listadoEECCResponses;

    }

    static String getAccountStatementId(String personId, String periodo) {
        return personId + "-" + periodo;

    }

}
