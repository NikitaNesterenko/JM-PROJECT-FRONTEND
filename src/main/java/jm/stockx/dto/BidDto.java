package jm.stockx.dto;

import lombok.*;
import org.joda.money.Money;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BidDto {

        private Long id;

        @Positive(message = "Цена должна быть положительной")
        @NotNull
        private Money price;

        private Boolean success;

        @NotBlank(message = "Item name is mandatory")
        private String itemName;

        @NotBlank(message = "User name is mandatory")
        private String userName;

}
