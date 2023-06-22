package id.ten.forumservices.dto.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SuccessResponse {

    private String status;
    private String message;
    private Object data;
}
