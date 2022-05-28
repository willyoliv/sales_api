package br.com.letscode.sales.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserResquestDTO {
    @NotNull(message = "The userCode field cannot be empty or null")
    private Long userCode;

    @NotEmpty(message = "The userName field cannot be empty or null")
    private String userName;

    @NotEmpty(message = "The role field cannot be empty or null")
    private String role;
}
