package jm.stockx.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemInfoDto {

    private Long id;

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private BigDecimal price;

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private BigDecimal lowestAsk;

    @Positive(message = "Ставка должна быть положительной")
    @NotNull
    private BigDecimal highestBid;

    private List<Double> sizes;

    private Long itemId;

    private String itemImgUrl;


//    public ItemInfoDto(ItemInfo itemInfo) {
//        this.id = itemInfo.getId();
//        this.price = itemInfo.getPrice();
//        this.lowestAsk = itemInfo.getLowestAsk();
//        this.highestBid = itemInfo.getHighestBid();
//        this.sizes = convertShoeSize(itemInfo.getSizes());
//        this.ItemId = itemInfo.getItem().getId();
//    }

//    private List<Double> convertShoeSize(Set<ShoeSize> shoeSizes){
//        List<Double> sizes = new ArrayList<>();
//        shoeSizes.forEach(e -> sizes.add(e.getSize()));
//        return sizes;
//    }
}
