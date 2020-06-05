package com.learnings.exceptions.utils;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class RandomUtils {

    public String generateRandomId(){
        return UUID.randomUUID().toString();
    }

    public boolean validateStringValue(String value) {

        boolean returnValue = false;
        if (value.equals("") || value.equals(" ")){
            returnValue = true;
        }
        return returnValue;
    }
}
