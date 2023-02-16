package com.transaction.transaction.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
}
