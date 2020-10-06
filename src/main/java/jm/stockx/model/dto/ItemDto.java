package jm.stockx.model.dto;

import jm.stockx.model.entity.Item;
import jm.stockx.model.enums.ItemColors;
import lombok.*;
import org.joda.money.Money;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;

    @NotBlank
    private String name;

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private Money retailPrice;

    private LocalDate dateRelease;

    @NotBlank
    private String condition;

    @NotBlank
    private String description;

    private ItemColors itemColors;

    public ItemDto(@NonNull Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.retailPrice = item.getRetailPrice();
        this.dateRelease = item.getReleaseDate();
        this.condition = item.getCondition();
        this.description = item.getDescription();
        this.itemColors = item.getItemColors();
    }
}
