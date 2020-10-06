package jm.stockx.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class News {
    private Long id;

    private String name;

    private LocalDateTime time;

    private String title;

    private String description;

    private String text;

    private String imageUrl;

    public News(
            String name,
            LocalDateTime time,
            String title,
            String description,
            String text) {
        this.name = name;
        this.time = time;
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public News(Long id, String name, LocalDateTime time, String title, String description, String text) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.title = title;
        this.description = description;
        this.text = text;
    }
}
