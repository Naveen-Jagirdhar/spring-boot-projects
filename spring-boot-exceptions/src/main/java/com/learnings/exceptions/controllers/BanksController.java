package com.learnings.exceptions.controllers;

import com.learnings.exceptions.models.ui.responses.BankApiResponse;
import com.learnings.exceptions.models.ui.responses.Banks;
import com.learnings.exceptions.models.ui.restmodels.BankDetails;
import com.learnings.exceptions.services.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/banks")
public class BanksController {

    @Autowired
    private BankServices bankServices;

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<?> addBanks(@RequestBody @Valid BankDetails bankDetails) {
         Banks banksMappedValues = bankServices.addBanks(bankDetails);
         return new ResponseEntity(banksMappedValues,HttpStatus.OK);
    }


    @GetMapping(path = "/{bankId}" ,
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<?> getBanks(@PathVariable String bankId){
            Banks banks = bankServices.fetchBankDetails(bankId);
            return new ResponseEntity<>(banks,HttpStatus.OK);
    }

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<?> getBankDetails(){
        List<Banks> banksList = bankServices.fetchCompleteDetails();
        return new ResponseEntity<>(banksList,HttpStatus.OK);
    }

    @PutMapping(path = "/{bankId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<?> updateBankDetails(@PathVariable String bankId , @RequestBody @Valid BankDetails bankDetails) {
        Banks bankMappedValues = bankServices.updateBankDetails(bankId,bankDetails);
        return new ResponseEntity<>(new BankApiResponse("Bank Details updated successfully for bankId:" + bankId),HttpStatus.OK);
    }
}
