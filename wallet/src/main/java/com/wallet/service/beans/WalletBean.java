package com.wallet.service.beans;

import com.wallet.service.entity.Wallet;
import com.wallet.service.entity.WalletStatus;
import com.wallet.service.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WalletBean {
    @Bean
    CommandLineRunner commandLineRunnerWa (WalletRepository walletRepository){
        return args->{
            Wallet w1 = Wallet.builder().id(1L).user_id(1L).amount(100D).status(WalletStatus.IN_PROGRESS).build();
            Wallet w2 = Wallet.builder().id(2L).user_id(2L).amount(235435D).status(WalletStatus.IN_PROGRESS).build();
            Wallet w4 = Wallet.builder().id(8L).user_id(3L).rib("SKCNKWD87236JDC").amount(339929D).status(WalletStatus.IN_PROGRESS).build();
            Wallet w3 = Wallet.builder().id(4L).user_id(1L).rib("KMAOKE8234782EDJMQI").amount(900000D).status(WalletStatus.BANNED).build();
            walletRepository.saveAll(List.of(w1,w2,w3,w4));
        };
    }
}
