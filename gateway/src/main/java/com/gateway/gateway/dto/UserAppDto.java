package com.gateway.gateway.dto;

import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAppDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

}
