package jm.stockx.model.entity;

import lombok.*;
import org.joda.money.Money;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ItemInfo {
    private Long id;

    private Set<ShoeSize> sizes = new HashSet<>();

    private Money price;

    private Money lowestAsk;

    private Money highestBid;

    private Item item;

    public ItemInfo(Set<ShoeSize> sizes, Money price, Money lowestAsk, Money highestBid, Item item) {
        this.sizes = sizes;
        this.price = price;
        this.lowestAsk = lowestAsk;
        this.highestBid = highestBid;
        this.item = item;
    }
}
