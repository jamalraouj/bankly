package com.user.user.DTO.transaction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
public class TransactionDTO {

    private Double amount;
    private Long fromUser;
    private Long toUser;
    private String fromWalletRib;
    private String toWalletRib;
    private Status status;
    private String message;
}
