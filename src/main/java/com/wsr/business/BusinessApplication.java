package com.wsr.business;

import com.wsr.business.data.models.User;
import com.wsr.business.data.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class BusinessApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BusinessApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);

        System.out.println("\n------------------------\n");

        User user = userRepository.findByName("радинка");
        System.out.println(user);
    }
}
