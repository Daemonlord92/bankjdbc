package org.blitmatthew.bankjdbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Long phone;
    private Integer creditScore;
    private LocalDate dateOfBirth;
    private Long userCredentialId;
}
