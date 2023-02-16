package com.transaction.transaction.proxy;

import com.transaction.transaction.DTO.wallet.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "wallet")
public interface WalletProxy {
    @GetMapping("/bankly/wallet")
    ResponseEntity<List<Wallet>> findAll();
    @GetMapping("/bankly/wallet/by-rib/{rib}")
    Optional<Wallet> findByRib(@PathVariable String rib);

    @PostMapping("/bankly/wallet/save")
    Wallet save(@RequestBody Wallet wallet);

}
