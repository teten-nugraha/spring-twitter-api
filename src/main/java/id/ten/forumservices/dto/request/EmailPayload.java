package id.ten.forumservices.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class EmailPayload {
    private String destination;
    private String subject;
    private String body;
}
