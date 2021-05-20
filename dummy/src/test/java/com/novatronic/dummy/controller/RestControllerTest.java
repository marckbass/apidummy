package com.novatronic.dummy.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;



@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listadoEecc() throws Exception {
        this.mockMvc.perform(get("/account-statements")
                .queryParam("personId","12345678")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listadoEecc_wrongPersonId() throws Exception {
        this.mockMvc.perform(get("/account-statements")
                .queryParam("personId","1234567")).andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void downloadFile() throws Exception {
        this.mockMvc.perform(get("/account-statements/{id}","12345678-202103"))
                .andExpect(status().isOk());
    }

    @Test
    public void downloadFile_wrongAccountStatementId() throws Exception {
        this.mockMvc.perform(get("/account-statements/{id}","12345678"))
                .andExpect(status().isNotFound());
    }

}
