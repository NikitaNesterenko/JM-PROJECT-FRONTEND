package jm.stockx.model.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserPortfolio {
    private Long id;

    @NonNull
    private User user;

    public UserPortfolio(User user) {
        this.user = user;
    }

}
