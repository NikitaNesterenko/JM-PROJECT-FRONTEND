package jm.stockx.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto {

    private Long id;

    @NotBlank(message = "Имя не должно быть null, пустым или состоять из одних лишь пробельных символов")
    private String name;

}
