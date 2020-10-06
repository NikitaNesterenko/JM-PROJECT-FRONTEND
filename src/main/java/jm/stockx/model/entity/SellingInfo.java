package jm.stockx.model.entity;

import jm.stockx.model.dto.ItemInfoDto;
import jm.stockx.model.enums.Status;
import lombok.*;
import org.joda.money.Money;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SellingInfo {
    private Long id;

    private User user;

    private Item item;

    private Long orderNumber;

    private LocalDateTime orderDate;

    private Status status;

    private Money price;

    public SellingInfo(User user,
                       ItemInfo itemInfo,
                       Item item,
                       Status status) {
        this.user = user;
        this.item = item;
        this.price = itemInfo.getPrice();
        this.orderDate = LocalDateTime.now();
        this.status = status;
    }

    public SellingInfo(User user,
                       ItemInfoDto itemInfoDto,
                       Item item) {
        this.user = user;
        this.item = item;
        this.price = itemInfoDto.getPrice();
        this.orderDate = LocalDateTime.now();
    }

    public SellingInfo(User user,
                       Item item,
                       ItemInfo itemInfo,
                       Long orderNumber,
                       Status status) {
        this(user, itemInfo, item, status);
        this.orderNumber = orderNumber;
    }
}
