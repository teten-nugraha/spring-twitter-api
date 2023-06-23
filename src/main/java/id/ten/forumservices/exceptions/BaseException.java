package id.ten.forumservices.exceptions;

import id.ten.forumservices.controller.BaseController;
import id.ten.forumservices.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseException extends BaseController {

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistException(ResourceAlreadyExistException exception) {
        return new ResponseEntity<>(constructErrorResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
