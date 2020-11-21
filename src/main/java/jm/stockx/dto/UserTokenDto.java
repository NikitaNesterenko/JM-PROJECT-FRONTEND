package jm.stockx.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String token;
    private String role;
}