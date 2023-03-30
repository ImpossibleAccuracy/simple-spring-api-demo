package com.wsr.business.data.payload;

public record SignUpForm(
        String email,
        String login,
        String password
) {
}
