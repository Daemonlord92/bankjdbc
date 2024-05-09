package org.blitmatthew.bankjdbc.dto;

public record PostNewUser(
        String firstName,
        String lastName,
        String email,
        String password,
        String address,
        long phone,
        Integer creditScore,
        String dateOfBirth
) {
}
