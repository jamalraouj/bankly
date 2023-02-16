package com.wallet.service.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Document
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Wallet {
    private Long id;
    @NotEmpty(message = "You are not have an account(User)")
    @Size(min = 1)
    private Long user_id;
    @Size(min = 0 , max = 999999999)
    private Double amount;
    @NotEmpty(message = "Your Rib is empty")
    @Size(min = 5)
    private String rib ;
    @NotEmpty(message = "Status Is empty")
    private WalletStatus status;
}
