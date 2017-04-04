package com.alexthered.me.utils.errors;

import com.alexthered.me.utils.errors.DuplicationException;
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
public class DuplicationExceptionHandler {

    /**
     * Globally handle @see DuplicationException
     * @param req web request
     * @param ex exception thrown
     * @return Exception Response
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicationException.class)
    public ResponseEntity<Object> handleProjectNotFoundException(HttpServletRequest req, DuplicationException ex) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("reason", ex.getMessage());
        map.put("url", req.getRequestURI());
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(HttpStatus.CONFLICT);
        ResponseEntity<Object> response = responseBuilder.body(map);
        return response;
    }

}
