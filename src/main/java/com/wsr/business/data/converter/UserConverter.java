package com.wsr.business.data.converter;

import com.wsr.business.data.dto.UserDto;
import com.wsr.business.data.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ModelConverter<User, UserDto> {
    @Override
    public UserDto convert(User model) {
        return UserDto.builder()
                .id(model.getId())
                .email(model.getEmail())
                .login(model.getLogin())
                .phone(model.getPhone())
                .name(model.getName())
                .surname(model.getSurname())
                .patronymic(model.getPatronymic())
                .organization(model.getOrganization())
                .comment(model.getComment())
                .birthDate(model.getBirthDate())
                .passportSeries(model.getPassportSeries())
                .passportNumber(model.getPassportNumber())
                .build();
    }
}
