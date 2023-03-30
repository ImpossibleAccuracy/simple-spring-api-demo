package com.wsr.business.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String login;
    private String phone;
    private String name;
    private String surname;
    private String patronymic;
    private String organization;
    private String comment;
    private Instant birthDate;
    private String passportSeries;
    private String passportNumber;
}
