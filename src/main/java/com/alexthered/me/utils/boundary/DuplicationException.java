package com.alexthered.me.utils.boundary;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hd on 04.04.17.
 */
public class DuplicationException extends RuntimeException{

    public DuplicationException(String message){
        super(message);
    }
}
