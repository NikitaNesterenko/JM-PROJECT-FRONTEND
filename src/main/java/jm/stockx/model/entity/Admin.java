package jm.stockx.model.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Admin extends User {

    public Admin(String firstName,
                 String lastName,
                 String email,
                 String username,
                 String password,
                 Byte sellerLevel,
                 Boolean vacationMode,
                 String localeTag,
                 String appleUserId) {
        super(firstName, lastName, email, username, password, sellerLevel, vacationMode, localeTag, appleUserId);
    }
}
