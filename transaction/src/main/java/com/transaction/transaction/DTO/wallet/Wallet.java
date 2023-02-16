package com.transaction.transaction.DTO.wallet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Wallet {
    private Long id;
    private Long user_id;
    private Double amount;
    private String rib ;
    private WalletStatus status;
    public void sumAmount(Double amount){
        this.amount += amount;
    }
    public Double minusAmount(Double amount){
        this.amount -= amount;
        return this.amount;
    }
}
