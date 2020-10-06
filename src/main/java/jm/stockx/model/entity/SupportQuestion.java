package jm.stockx.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SupportQuestion {
    private Long id;

    private String text;

    private Long orderNumber;

    private LocalDateTime dateTime;
}
