package jm.stockx.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryViews {
    private Long id;

    private User user;

    private Item item;

    private LocalDateTime viewDate;
}
