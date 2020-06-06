package com.learnings.exceptions.controllertests;

import com.jayway.jsonpath.JsonPath;
import com.learnings.exceptions.controllers.BanksController;
import com.learnings.exceptions.models.ui.responses.Banks;
import com.learnings.exceptions.models.ui.restmodels.BankDetails;
import com.learnings.exceptions.services.BankServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BanksController.class)
@RunWith(SpringRunner.class)
public class BankControllerTests {

    @MockBean
    private BankServices services;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addBanksDetails() {

        Banks banks = new Banks();
        banks.setBankNo("21212063-e6ea-47da-a4f2-f9d9bf53e346");
        banks.setBankId("1");
        banks.setBankName("Soft Bank");

        when(services.addBanks(any(BankDetails.class))).thenReturn(banks);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/banks")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\n" +
                        "  \"bankName\":\"Soft Bank\",\n" +
                        "  \"bankId\":\"17\"\n" +
                        "}");
        try {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.bankNo").value("21212063-e6ea-47da-a4f2-f9d9bf53e346"))
                    .andExpect(jsonPath("$.bankName").value("Soft Bank"))
                    .andExpect(jsonPath("$.bankId").value("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getBankDetailsTest() throws Exception {
        when(
                services.fetchCompleteDetails())
                .thenReturn(Arrays.asList(
                        new Banks("21212063-e6ea-47da-a4f2-f9d9bf53e346", "Soft Bank", "1"),
                        new Banks("f0c08a07-54a9-4955-803c-3a6860eed15d", "SBI Bank", "2")))
                .thenReturn(Arrays.asList());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/banks")
                .accept(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void getBanksTest() throws Exception {
        when(services.fetchBankDetails("21212063-e6ea-47da-a4f2-f9d9bf53e346"))
                .thenReturn(new Banks("21212063-e6ea-47da-a4f2-f9d9bf53e346", "Soft Bank", "1"));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/banks/21212063-e6ea-47da-a4f2-f9d9bf53e346")
                .accept(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(jsonPath("$.bankNo").value("21212063-e6ea-47da-a4f2-f9d9bf53e346"))
                .andExpect(jsonPath("$.bankName").value("Soft Bank"))
                .andExpect(jsonPath("$.bankId").value("1"));
        ;
    }
}