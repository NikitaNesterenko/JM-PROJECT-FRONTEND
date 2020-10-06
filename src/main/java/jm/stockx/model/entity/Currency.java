package jm.stockx.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Currency {
    private Long id;

    private String name;

    public Currency(String name) {
        this.name = name;
    }
}
