package com.user.user.controller;

import com.user.user.DTO.transaction.TransactionDTO;
import com.user.user.entity.TableUser;
import com.user.user.service.UserService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    public UserController(TransactionProxy transactionProxy) {
//        this.transactionProxy = transactionProxy;
//    }

    @GetMapping("/{id}")
//    @Retry(name = "default", fallbackMethod = "exceptionFindById")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<TableUser> user = userService.findById(id);
        if (!user.isPresent()) {
            return new ResponseEntity<String>("Distance ID " + id + " Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TableUser>(user.get(), HttpStatus.OK);//ResponseEntity.ok(user.get());
    }
    @GetMapping
    public List<TableUser> findAll(){
        return userService.findAll();
    }


    //{
    //
    //    "amount":"234234.345",
    //    "fromUser":"2",
    //    "toUser":"1",
    //    "fromWalletRib":"3824723542348",
    //    "toWalletRib":"324234"
    //
    //}
     @PostMapping("/transaction/new")
    public TransactionDTO saveTransaction(@RequestBody TransactionDTO transactionDTO){
        return userService.saveTransaction(transactionDTO);
    }
    @GetMapping("/transactions")
    public List<TransactionDTO> findAllTransaction(){
        return userService.findAllTransaction();
    }

    @GetMapping("/validate-token")
    public TableUser validateToken(@PathParam("token") String token){
        return userService.validateToken(token);
    }


    //EXCEPTIONS
    public String exceptionFindById(Exception e){
        return "error in server or account not found"+e.getMessage();
    }


}
