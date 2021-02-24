package jm.stockx.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemSearchDto {
    private String itemCategory;
    private Long count;

}
