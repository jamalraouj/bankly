package com.transaction.transaction.proxy;

import com.transaction.transaction.DTO.UserDTO;
import com.transaction.transaction.entity.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "user")
public interface UserProxy {
        @GetMapping("/bankly/transaction")
        ResponseEntity<List<Transaction>> findAll();
        @GetMapping("/bankly/user/{id}")
        Optional<UserDTO> findById(@PathVariable Long id);
//        @RequestMapping( value = "/Management/portefeuil/update",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //
    //        @PostMapping("/bankly/transaction/new")
    //        TransactionDTO saveTransaction(TransactionDTO transactionDTO);

}
