package com.wallet.service.services;

import com.wallet.service.entity.Wallet;
import com.wallet.service.entity.WalletStatus;
import com.wallet.service.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService implements IService<Wallet,Long >{
    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet save(@Valid Wallet wallet) {
        if (wallet.getRib().isEmpty()) {
            wallet.setRib(UUID.randomUUID().toString());
        }
        if (wallet.getUser_id() >= 1) {
            if (wallet.getStatus() == null) {
                wallet.setStatus(WalletStatus.IN_PROGRESS);
            }
//            wallet.setMessage("Success");
            return walletRepository.save(wallet);
        }
//        wallet.setMessage("ERROR: ");
        return wallet;
    }

    @Override
    public boolean delete(Long l) {
        Optional<Wallet> wallet = walletRepository.findById(l);
        if(wallet.isPresent()){
            wallet.get().setStatus(WalletStatus.DELETED);
            return true;
        }
        return false;
    }

    @Override
    public List<Wallet> findAll() {
        return  walletRepository.findAll();
    }

    @Override
    public Wallet findById(Long l) {
        Optional<Wallet> wallet = walletRepository.findById(l);
        if(wallet.isPresent()){
            return wallet.get();
        }
        return null;
    }

    public List<Wallet> findByUserId(Long id) {
//         Optional<List<Wallet>> users = walletRepository.findAllByUser_id(id);//findAllByUser_id
         return null;
    }
    public Wallet findByRib(String rib) {
        Optional<Wallet> wallet = walletRepository.findByRib(rib);
        if (wallet.isPresent()){
            return wallet.get();
        }
        return null;
    }
}
