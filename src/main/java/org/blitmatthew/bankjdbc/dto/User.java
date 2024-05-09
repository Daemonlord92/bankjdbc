package org.blitmatthew.bankjdbc.dto;

import java.time.LocalDate;

public record User(Long id, String firstName, String lastName, String address, long phone, String email, Integer creditScore,
                   LocalDate dob) {
}
