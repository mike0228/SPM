package cn.edu.njust.dev.ses.main.dto.api;

import lombok.Data;

@Data
public class LoginCredentialsDTO {
    private String login;
    private String password;
    private String rememberMe;
}
