package id.ten.forumservices.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class SuccessResponse<T> {

    private String status;
    private String message;
    private T data;
}
