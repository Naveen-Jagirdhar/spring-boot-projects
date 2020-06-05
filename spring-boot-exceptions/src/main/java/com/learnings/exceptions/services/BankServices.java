package com.learnings.exceptions.services;

import com.learnings.exceptions.exceptions.NoDataAvailableException;
import com.learnings.exceptions.models.ui.responses.Banks;
import com.learnings.exceptions.models.ui.restmodels.BankDetails;
import com.learnings.exceptions.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankServices {

    Map<String, Banks> banksTemporaryMap = new HashMap<>();

    @Autowired
    private RandomUtils randomUtils;

    public Banks addBanks(BankDetails bankDetails) {

        String id = randomUtils.generateRandomId();
        Banks banks = new Banks();
        banks.setBankNo(id);
        banks.setBankId(bankDetails.getBankId());
        banks.setBankName(bankDetails.getBankName());

        banksTemporaryMap.put(id , banks);

        return banks;
    }

    public List<Banks> fetchCompleteDetails() {
        List<Banks> banksList = new ArrayList<>(banksTemporaryMap.values());
        return banksList;
    }

    public Banks fetchBankDetails(String bankId) {

        Banks banks = new Banks();
        if (banksTemporaryMap.containsKey(bankId)) {
           banks = banksTemporaryMap.get(bankId);
        }
        else {
            throw new NoDataAvailableException("Bank Details could not be fetched with requested Id:" + bankId);
        }

        return banks;
    }

    public Banks updateBankDetails(String bankId, BankDetails bankDetails) {
        Banks banks = fetchBankDetails(bankId);

        banks.setBankId(bankDetails.getBankId());
        banks.setBankName(bankDetails.getBankName());

        banksTemporaryMap.put(bankId,banks);
        return banks;
    }
}