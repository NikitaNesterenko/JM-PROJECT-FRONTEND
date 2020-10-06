package jm.stockx.model.entity;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Style {
    private Long id;

    private String name;

    public Style(String name) {
        this.name = name;
    }
}
