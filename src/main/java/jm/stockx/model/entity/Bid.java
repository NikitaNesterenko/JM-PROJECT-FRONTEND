package jm.stockx.model.entity;

import lombok.*;
import org.joda.money.Money;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Bid {
    private Long id;

    private Money price;

    private Boolean success;

    private User user;

    private Item item;

    public Bid(Money price, Boolean success, User user, Item item) {
        this.price = price;
        this.success = success;
        this.user = user;
        this.item = item;
    }
}
