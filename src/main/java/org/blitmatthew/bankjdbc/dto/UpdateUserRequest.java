package org.blitmatthew.bankjdbc.dto;

import java.time.LocalDate;

public record UpdateUserRequest(
        long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String address,
        long phone,
        Integer creditScore,
        LocalDate dateOfBirth
) {
}
