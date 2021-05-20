/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novatronic.api.eecc.bean;

/**
 *
 * @author mrios
 */
public class AccountStatementsResponse {

    private String personId;
    private String periods;
    private String accountStatementId;
    private String referenceId;
    private String contentType;

    public AccountStatementsResponse(String personId, String periods, String accountStatementId, String referenceId, String contentType) {
        this.personId = personId;
        this.periods = periods;
        this.accountStatementId = accountStatementId;
        this.referenceId = referenceId;
        this.contentType = contentType;
    }

    public AccountStatementsResponse() {
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "AccountStatementsResponse{" + "personId=" + personId + ", periods=" + periods + ", accountStatementId=" + getAccountStatementId() + ", referenceId=" + referenceId + ", contentType=" + contentType + '}';
    }

    /**
     * @return the accountStatementId
     */
    public String getAccountStatementId() {
        return accountStatementId;
    }

    /**
     * @param accountStatementId the accountStatementId to set
     */
    public void setAccountStatementId(String accountStatementId) {
        this.accountStatementId = accountStatementId;
    }
    
    

}
