package jm.stockx.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyPostDto {

    @NotBlank
    private String name;

}
