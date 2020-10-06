package jm.stockx.model.entity;

import jm.stockx.model.enums.ShoeSizeTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoeSize {
    private Long id;

    private Double size;

    private ShoeSizeTypes sizeTypes;

    private Set<ItemInfo> items = new HashSet<>();

    public ShoeSize(Double size, ShoeSizeTypes sizeTypes) {
        this.size = size;
        this.sizeTypes = sizeTypes;
    }

    @Override
    public String toString() {
        return size + " " + sizeTypes;
    }
}
