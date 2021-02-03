package jm.stockx.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ItemInfoDtoDecimal implements Serializable {

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

    private String size;

    private Long itemId;

    private String itemImgUrl;

    private String name;


    @Override
    public String toString() {
        return "ItemInfoDtoDecimal{" +
                "id=" + id +
                ", price=" + price +
                ", lowestAsk=" + lowestAsk +
                ", highestBid=" + highestBid +
                ", size='" + size + '\'' +
                ", ItemId=" + itemId +
                ", itemImgUrl='" + itemImgUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
