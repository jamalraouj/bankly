package com.user.user.service;

import com.user.user.DTO.transaction.TransactionDTO;
import com.user.user.configspringsecurity.JwtUtils;
import com.user.user.entity.Role;
import com.user.user.entity.TableUser;
import com.user.user.proxy.TransactionProxy;
import com.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    TransactionProxy transactionProxy;

    @Autowired
    UserRepository userRepository;
    public Optional<TableUser> findById(Long id){
        Optional<TableUser> user = userRepository.findById(id);
        return user;
    }

    public TableUser findByEmail(String email){
        Optional<TableUser> userOptional = Optional.empty();
        String message;
        if(email == null || email == ""){
            message= "You must adding email";
        }else {
            userOptional = userRepository.findByEmail( email);
            if(userOptional.isPresent() ){
                message= "Success";
            }
            else {
                message = "This email does not exist";
            }
        }

        return userOptional.get();
    }
    public List<TableUser> findAll() {
        return userRepository.findAll();
    }

    public List<TransactionDTO> findAllTransaction() {
        List<TransactionDTO> transactionList = transactionProxy.findAll();
        return transactionList;
    }

    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        TransactionDTO transaction = transactionProxy.saveTransaction(transactionDTO);
        return transaction;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<TableUser> user=userRepository.findByEmail(email);
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Role.USER.toString()));
        authorities.add(new SimpleGrantedAuthority(Role.ADMIN.toString()));
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPassword(),authorities);
    }

    public TableUser validateToken(String token) {
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Role.USER.toString()));
        authorities.add(new SimpleGrantedAuthority(Role.ADMIN.toString()));

        final String userEmail = jwtUtils.extractUsername(token);
        TableUser userApp = findByEmail(userEmail);
        UserDetails user = new User(userApp.getEmail() , userApp.getPassword() ,authorities);
        if (userEmail.equals(userApp.getEmail()) && !jwtUtils.isTokenExpired(token)) {
            jwtUtils.generateToken(user);
            return userApp;
        } else {
            return null;
        }
    }
}
