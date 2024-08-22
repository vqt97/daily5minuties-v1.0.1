package org.programing.daily5minuties.auth.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String userName;
    private String password;
}
