package com.user.user.controller;


import com.user.user.DTO.auth.AuthenticationRequest;
import com.user.user.configspringsecurity.JwtUtils;
import com.user.user.entity.TableUser;
import com.user.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    @ResponseBody
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){

        Optional<TableUser> user = Optional.ofNullable(userService.findByEmail(request.getEmail()));
        System.out.println(user);
        if(user.isPresent()){
            return ResponseEntity.ok(Collections.singletonList(jwtUtils.generateToken(new User(user.get().getEmail(),user.get().getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.get().getRole().toString())))) ));
        }
        return ResponseEntity.ok(HttpStatus.BAD_REQUEST );
    }
//    @PostMapping("/signup")
//    @ResponseBody
//    public ResponseEntity<ResponseVm> signup(@Valid @RequestBody RegisterDTO registerDTO){
//
//        UserEntity userEntity = userService.register(registerDTO);
//       return ResponseEntity.ok(new ResponseVm(HttpStatus.ACCEPTED , "Success" , Collections.singletonList(userEntity)));
//
//    }
}
