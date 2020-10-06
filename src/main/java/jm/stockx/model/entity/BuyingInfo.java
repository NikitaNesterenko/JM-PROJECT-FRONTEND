package jm.stockx.model.entity;

import jm.stockx.model.dto.ItemInfoDto;
import jm.stockx.model.enums.Status;
import lombok.*;
import org.joda.money.Money;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BuyingInfo {
    private Long id;

    private LocalDateTime buyingTimeStamp;

    private Money buyingPrice;

    private Set<Item> boughtItems;

    private Set<PaymentInfo> paymentsInfo;

    private Status status;

    public BuyingInfo(ItemInfoDto itemInfoDto) {
        this.buyingTimeStamp = LocalDateTime.now();
        this.buyingPrice = itemInfoDto.getPrice();
    }
}
