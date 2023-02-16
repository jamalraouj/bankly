package com.wallet.service.controller;

import com.wallet.service.entity.Wallet;
import com.wallet.service.services.WalletService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping
    public List<Wallet> findAll(){
        return walletService.findAll();
    }
    @PostMapping({"/new","/save"})
    public Wallet save(@RequestBody Wallet wallet){
          return walletService.save(wallet);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return walletService.delete(id);
    }
    @GetMapping("/{id}")
    public Wallet findById(@PathVariable Long id){
        return walletService.findById(id);
    }


    @GetMapping("/by-user/{id}")
    public List<Wallet> findByUserId(@PathVariable Long id){
        return walletService.findByUserId(id);
    }

    @GetMapping("/by-rib/{rib}")
    public ResponseEntity<Wallet> findByRib(@PathVariable String rib){
        Optional<Wallet> walletOptional = Optional.ofNullable(walletService.findByRib(rib));
        if (walletOptional.isPresent()){
            return ResponseEntity.ok(walletOptional.get());
        }
        return null;
    }

    public List<String>  findAllException(Exception e){
        return List.of("500","ERROR","MESSAGE: this api has an error.");
    }
}
