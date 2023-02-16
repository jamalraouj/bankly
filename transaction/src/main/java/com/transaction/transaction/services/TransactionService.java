package com.transaction.transaction.services;

import com.transaction.transaction.DTO.UserDTO;
import com.transaction.transaction.DTO.wallet.Wallet;
import com.transaction.transaction.entity.Status;
import com.transaction.transaction.entity.Transaction;
import com.transaction.transaction.proxy.UserProxy;
import com.transaction.transaction.proxy.WalletProxy;
import com.transaction.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserProxy userProxy;
    @Autowired
    WalletProxy walletProxy;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        Optional<Transaction> transaction = Optional.of(new Transaction());
        if (id != null && id > 0) {
            transaction = transactionRepository.findById(id);
            if (transaction.isPresent()) {
                transaction.get().setMessage("Success");

            } else {
                transaction.get().setMessage("this ID are not exist");
            }
        } else {
            transaction.get().setMessage("You don't have an ID");
        }
        return transaction.get();

    }

    @Transactional
    public Transaction save(Transaction transaction) {
        if (transaction.getAmount() > 0) {
//Optional<UserDTO>
            Optional<UserDTO> fromUser = userProxy.findById(transaction.getFromUser());
            if (fromUser.isPresent()) {
                Optional<UserDTO> toUser = userProxy.findById(transaction.getToUser());
                if (toUser.isPresent()) {
                    Optional<Wallet> fromWallet = walletProxy.findByRib(transaction.getFromWalletRib());
                    if(fromWallet.isPresent()){
                        Optional<Wallet> toWallet = walletProxy.findByRib(transaction.getToWalletRib());
                        if (toWallet.isPresent()){
                          Double fromAmount = fromWallet.get().minusAmount(transaction.getAmount());
                          if(fromAmount>transaction.getAmount()){
                              toWallet.get().sumAmount(transaction.getAmount());
                              Wallet toW = walletProxy.save(toWallet.get());
                              Wallet fromW = walletProxy.save(fromWallet.get());
                              transaction.setStatus(Status.FINISHED);
                              transactionRepository.save(transaction);

                          }else transaction.setMessage("Your Amount not enough ");




                        }else transaction.setMessage("Second wallet not found");
                    }else transaction.setMessage("Your wallet not found");
                } else transaction.setMessage("Another account are not found: ");


            }else transaction.setMessage("Your account are not found: ");
//          System.out.println(fromUser.get());
            } else transaction.setMessage("Your amount are under Zero: ");


            return transaction;
        }

//    public UserDTO findUserById(Long id) {
//        ResponseEntity user = ResponseEntity.ok(userProxy.findById(id));
//        System.out.println(user);
//        return (UserDTO)user.getBody();
//    }
    }
