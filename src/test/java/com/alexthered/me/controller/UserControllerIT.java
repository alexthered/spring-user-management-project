package com.alexthered.me.controller;

import com.alexthered.me.SpringUserManagementProjectApplication;
import com.alexthered.me.domain.User;
import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by hd on 04.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerIT {
    private static final String USER_ENDPOINT = "http://localhost:8080/users";

    @Test
    public void testCreateUser() {
        Map<String, Object> param = new HashMap<>();
        param.put("firstName", "test");
        param.put("lastName", "user");
        param.put("password", "test12334");

        given().contentType(ContentType.JSON).body(param)
                .when().post(USER_ENDPOINT).then()
                .log().ifError()
                .assertThat().statusCode(equalTo(HttpStatus.OK.value()));
    }

}