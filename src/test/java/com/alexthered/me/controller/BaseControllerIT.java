package com.alexthered.me.controller;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by hd on 04.04.17.
 */
public class BaseControllerIT {

    @BeforeClass
    public void init() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
    }
}
