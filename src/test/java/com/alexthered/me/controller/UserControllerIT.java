package com.alexthered.me.controller;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by hd on 04.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerIT {
    private static final String USER_ENDPOINT = "/users";
    Map<String, Object> userParam = new HashMap<>();


    @Before
    public void init(){
        userParam.put("firstName", "test");
        userParam.put("lastName", "user");
        userParam.put("password", "test12334");
        userParam.put("email", "test.user@alexthered.me");
    }

    @Test
    public void testCreateUserWithEmptyFirstName() throws Exception {

        userParam.put("firstName", null);
        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().all()
                .assertThat().statusCode(equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testCreateUserWithEmptyLastName() throws Exception {

        userParam.put("lastName", null);
        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().all()
                .assertThat().statusCode(equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testCreateUserWithEmptyEmail() throws Exception {

        userParam.put("email", null);
        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().all()
                .assertThat().statusCode(equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testCreateUserWithInvalidEmail() throws Exception {

        userParam.put("email", "test.user@faf@sdad");
        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().all()
                .assertThat().statusCode(equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testCreateUserWithEmptyPassword() throws Exception {

        userParam.put("password", null);
        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().all()
                .assertThat().statusCode(equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testCreateUserWithTooShortPassword() throws Exception {

        userParam.put("password", "123d");
        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().ifError()
                .assertThat().statusCode(equalTo(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    public void testCreateValidUser() throws Exception{

        given().contentType(ContentType.JSON).body(userParam)
                .when().post(USER_ENDPOINT).then()
                .log().ifError()
                .assertThat().statusCode(equalTo(HttpStatus.CREATED.value()))
                .body("firstName", equalTo("test"))
                .body("lastName", equalTo("user"))
                .body("password", equalTo("test12334"))
                .body("email", equalTo("test.user@alexthered.me"));
    }

    @Test
    public void getAllUsers() throws Exception {

    }

}