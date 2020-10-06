package jm.stockx.model.entity;

import jm.stockx.model.enums.ItemCategory;
import jm.stockx.model.enums.ItemColors;
import lombok.*;
import org.joda.money.Money;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Item {
    private Long id;

    private String name;

    private Money retailPrice;

    private LocalDate releaseDate;

    private String condition;

    private String description;

    private Brand brand;

    private String itemImageUrl;

    private Style style;

    private ItemColors itemColors;

    private ItemCategory itemCategory;

    public Item(Long id,
                String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description) {
        this.id = id;
        this.name = name;
        this.retailPrice = retailPrice;
        this.releaseDate = releaseDate;
        this.condition = condition;
        this.description = description;
    }

    public Item(Long id,
                String name,
                Money retailPrice,
                String condition,
                String description) {
        this.id = id;
        this.name = name;
        this.retailPrice = retailPrice;
        this.condition = condition;
        this.description = description;
    }

    public Item(String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.releaseDate = releaseDate;
        this.condition = condition;
        this.description = description;
    }

    public Item(String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description,
                Brand brand) {
        this(name, retailPrice, releaseDate, condition, description);
        this.brand = brand;
    }

    public Item(String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description,
                Brand brand,
                Style style) {
        this(name, retailPrice, releaseDate, condition, description, brand);
        this.style = style;
    }

    public Item(String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description,
                Brand brand,
                Style style,
                ItemCategory itemCategory) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.releaseDate = releaseDate;
        this.condition = condition;
        this.description = description;
        this.brand = brand;
        this.style = style;
        this.itemCategory = itemCategory;
    }

    public Item(String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description,
                Brand brand,
                String itemImageUrl,
                Style style) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.releaseDate = releaseDate;
        this.condition = condition;
        this.description = description;
        this.brand = brand;
        this.itemImageUrl = itemImageUrl;
        this.style = style;
    }

    public Item(String name,
                Money retailPrice,
                LocalDate releaseDate,
                String condition,
                String description,
                Brand brand,
                String itemImageUrl,
                Style style,
                Money price,
                Money lowestAsk,
                Money highestBid,
                Set<ShoeSize> sizes) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.releaseDate = releaseDate;
        this.condition = condition;
        this.description = description;
        this.brand = brand;
        this.itemImageUrl = itemImageUrl;
        this.style = style;
        ItemInfo itemInfo = new ItemInfo(sizes, price, lowestAsk, highestBid, this);
    }

}
