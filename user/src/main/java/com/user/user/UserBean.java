package com.user.user;

import com.user.user.entity.Role;
import com.user.user.entity.TableUser;
import com.user.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserBean {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args->{
            TableUser u1 = TableUser.builder().name("amin").email("amin@gmail.com").password("1233").role(Role.USER).build();
            TableUser u2 = TableUser.builder().name("youssef").email("youssef@gmail.com").password("1233").role(Role.USER).build();
            TableUser u3 = TableUser.builder().name("ahmad").email("ahmad@gmail.com").password("1233").role(Role.ADMIN).build();
            userRepository.saveAll(List.of(u1,u2,u3));
        };
    }
}
