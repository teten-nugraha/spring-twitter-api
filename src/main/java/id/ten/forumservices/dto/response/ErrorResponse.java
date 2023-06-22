package id.ten.forumservices.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorResponse {

    private String error;
    private String message;
}
