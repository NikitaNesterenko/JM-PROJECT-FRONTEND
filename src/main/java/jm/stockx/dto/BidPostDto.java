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
public class BidPostDto {

    private Long id;

    private String price;

    private Boolean success;

    @NotBlank
    private Long itemInfoId;

    @NotBlank
    private Long userId;
}
