package com.alexthered.me.utils.errors;

import org.aspectj.weaver.ast.Not;

/**
 * Created by hd on 04.04.17.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}
