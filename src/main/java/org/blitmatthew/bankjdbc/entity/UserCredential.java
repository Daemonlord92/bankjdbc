package org.blitmatthew.bankjdbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserCredential {
    @Id
    private Long id;
    private String email;
    private String password;
}
