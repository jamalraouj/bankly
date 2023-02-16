package com.user.user.proxy;

import com.user.user.DTO.transaction.TransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "transaction")
public interface TransactionProxy {
        @GetMapping("/bankly/transaction")
        List<TransactionDTO> findAll();

        @RequestMapping( value = "/bankly/transaction/new",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
        TransactionDTO saveTransaction(@RequestBody TransactionDTO transactionDTO);
}
