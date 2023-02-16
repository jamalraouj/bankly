package com.transaction.transaction.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Long fromUser;
    private Long toUser;
    private String fromWalletRib;
    private String toWalletRib;
    private Status status;

    @Transient
    private String message;
}
