package jm.stockx.model.entity;

import jm.stockx.model.dto.BrandPostDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Long id;

    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Brand(BrandPostDto brandPostDto) {
        this.name = brandPostDto.getName();
    }
}
