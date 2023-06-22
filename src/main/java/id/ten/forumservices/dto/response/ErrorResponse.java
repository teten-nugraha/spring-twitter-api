package id.ten.forumservices.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ErrorResponse {

    private String error;
    private String message;
}
