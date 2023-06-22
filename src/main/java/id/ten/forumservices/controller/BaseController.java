package id.ten.forumservices.controller;

import id.ten.forumservices.dto.response.ErrorResponse;
import id.ten.forumservices.dto.response.SuccessResponse;

public abstract class BaseController {

    public SuccessResponse contructSuccessResponse(Object data, String message) {
        SuccessResponse successResponse = SuccessResponse.builder()
                .data(data)
                .message(message)
                .status("success")
                .build();
        return successResponse;
    }

    public ErrorResponse constructErrorResponse(String message) {
        ErrorResponse errorResponse =
                ErrorResponse.builder().error("error").message(message).build();
        return errorResponse;
    }
}
