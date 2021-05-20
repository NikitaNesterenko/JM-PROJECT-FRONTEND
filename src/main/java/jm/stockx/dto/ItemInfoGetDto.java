package jm.stockx.dto;
import lombok.*;
import org.joda.money.Money;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemInfoGetDto {

    private String itemName;

    private String itemImageUrl;

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private Money lowestAsk;

//    public ItemInfoGetDto(ItemInfo itemInfo) {
//        this.ItemName = itemInfo.getItem().getName();
//        this.itemImageUrl = itemInfo.getItem().getItemImageUrl();
//        this.lowestAsk = itemInfo.getLowestAsk();
//    }
}
