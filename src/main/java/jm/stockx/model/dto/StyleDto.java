package jm.stockx.model.dto;

import jm.stockx.model.entity.Style;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StyleDto {

    private Long id;

    @NotBlank
    private String name;

    public StyleDto(Style style) {
        this.id = style.getId();
        this.name = style.getName();
    }
}
