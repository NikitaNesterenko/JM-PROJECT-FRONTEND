package jm.stockx.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUserDto {

    @NotBlank
    private String token;

    @NotNull
    private UserDto userDTO;
}
