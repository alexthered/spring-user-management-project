package com.alexthered.me.utils.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hd on 04.04.17.
 */
@ControllerAdvice
public class NotFoundExceptionHandler {

    /**
     * Globally handle @see NotFoundException
     * @param req web request
     * @param ex exception thrown
     * @return Exception Response
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handletNotFoundException(HttpServletRequest req, DuplicationException ex) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("reason", ex.getMessage());
        map.put("url", req.getRequestURI());
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(HttpStatus.NOT_FOUND);
        ResponseEntity<Object> response = responseBuilder.body(map);
        return response;
    }
}
