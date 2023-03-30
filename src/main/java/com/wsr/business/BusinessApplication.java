package com.wsr.business;

import com.wsr.business.data.models.Employee;
import com.wsr.business.data.models.Subdivision;
import com.wsr.business.data.models.User;
import com.wsr.business.data.repo.EmployeeRepository;
import com.wsr.business.data.repo.SubdivisionRepository;
import com.wsr.business.data.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

@SpringBootApplication
public class BusinessApplication {

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext context = SpringApplication.run(BusinessApplication.class, args);

        if (args.length > 0 && args[0].equals("--import-console")) {
            importData(context);
        }
    }

    public static void importData(ApplicationContext context) throws ParseException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserRepository userRepository = context.getBean(UserRepository.class);
        SubdivisionRepository subdivisionRepository = context.getBean(SubdivisionRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null) {
            if (line.isBlank()) continue;

            String[] data = Arrays.copyOf(line.split("\t"), 20);

            if (Objects.equals(data[0], "user")) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.y");
                Instant birthDate = dateFormat.parse(data[6]).toInstant();

                User user = User.builder()
                        .surname(data[1])
                        .name(data[2])
                        .patronymic(data[3])
                        .phone(data[4])
                        .email(data[5])
                        .birthDate(birthDate)
                        .passportSeries(data[7])
                        .passportNumber(data[8])
                        .login(data[9])
                        .password(passwordEncoder.encode(data[10]))
                        .creationTime(Instant.now())
                        .build();

                userRepository.save(user);
            } else if (Objects.equals(data[0], "subdivision")) {
                Subdivision subdivision = new Subdivision();
                subdivision.setTitle(data[1]);
                subdivisionRepository.save(subdivision);
            } else if (Objects.equals(data[0], "employee")) {
                Employee employee = Employee.builder()
                        .surname(data[1])
                        .name(data[2])
                        .patronymic(data[3])
                        .subdivision(subdivisionRepository.findByTitle(data[4]))
                        .department(data[5])
                        .code(data[6])
                        .build();

                employeeRepository.save(employee);
            }
        }
    }

}
