package jm.stockx.model.dto;

import jm.stockx.model.entity.TokenRecovery;
import jm.stockx.model.entity.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TokenRecoveryPostDto {

    @NotNull
    private User user;

    @NotNull
    private String hash;

    @NotNull
    private String hashEmail;

    @NotNull
    private Date startTime;

    public TokenRecoveryPostDto(TokenRecovery tokenRecovery) {
        this.user = tokenRecovery.getUser();
        this.hash = tokenRecovery.getHash();
        this.hashEmail = tokenRecovery.getHashEmail();
        this.startTime = tokenRecovery.getStartTime();
    }

}
