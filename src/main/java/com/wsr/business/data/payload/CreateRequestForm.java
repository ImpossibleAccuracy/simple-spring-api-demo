package com.wsr.business.data.payload;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public record CreateRequestForm(
        Date startTime,
        Date endTime,
        String objective,
        Long subdivision,
        String employee,
        String name,
        String surname,
        String patronymic,
        String phone,
        String email,
        String organization,
        String comment,
        Instant birthDate,
        String passportSeries,
        String passportNumber,
        List<GroupUser> group
) {
}

