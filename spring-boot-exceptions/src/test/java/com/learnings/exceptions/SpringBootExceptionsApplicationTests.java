package com.learnings.exceptions;

import com.learnings.exceptions.models.ui.responses.Banks;
import com.learnings.exceptions.models.ui.restmodels.BankDetails;
import com.learnings.exceptions.services.BankServices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootExceptionsApplicationTests {

	@Test
	void contextLoads() {
	}


}
