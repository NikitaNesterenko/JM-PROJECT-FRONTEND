package jm.stockx.model.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenRegistration {
    private Long id;

    private User user;

    private String hash;

    private String hashEmail;

    private Date startTime;
}
