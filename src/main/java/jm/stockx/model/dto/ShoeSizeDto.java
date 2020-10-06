package jm.stockx.model.dto;

import jm.stockx.model.entity.ShoeSize;
import jm.stockx.model.enums.ShoeSizeTypes;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoeSizeDto {

    private Long id;

    @Min(3)
    @NotNull
    private Double size;

    @NotNull
    private ShoeSizeTypes sizeTypes;

    public ShoeSizeDto(ShoeSize shoesize) {
        this.id = shoesize.getId();
        this.size = shoesize.getSize();
        this.sizeTypes = shoesize.getSizeTypes();
    }
}
