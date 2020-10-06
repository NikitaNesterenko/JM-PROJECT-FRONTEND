package jm.stockx.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

@Getter
@Setter
@ToString
//@NoArgsConstructor
public class User {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String imageUrl;

    private Byte sellerLevel;

    private Boolean vacationMode;

    private String appleUserId;

    private String localeTag;

    @NotNull
    private Role role;

    private Boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private Set<BuyingInfo> buyingInfo;

    public User(String firstName,
                String lastName,
                String email,
                String username,
                String password,
                Byte sellerLevel,
                Boolean vacationMode,
                String localeTag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.sellerLevel = sellerLevel;
        this.vacationMode = vacationMode;
        this.localeTag = localeTag;
    }

    public User(String firstName,
                String lastName,
                String email,
                String username,
                String password,
                Byte sellerLevel,
                Boolean vacationMode,
                String appleUserId,
                Set<BuyingInfo> buyingInfo) {
        this(firstName, lastName, email, username, password, sellerLevel, vacationMode, appleUserId);
        this.buyingInfo = buyingInfo;
    }

    public User(String firstName,
                String lastName,
                String email,
                String username,
                String password,
                Byte sellerLevel,
                Boolean vacationMode,
                String appleUserId,
                String localeTag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.sellerLevel = sellerLevel;
        this.vacationMode = vacationMode;
        this.appleUserId = appleUserId;
        this.localeTag = localeTag;
    }

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public User(Long id,
                String firstName,
                String lastName,
                String email,
                String username,
                String password,
                byte sellerLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.sellerLevel = sellerLevel;
    }

    public User() {
        super();
        this.active = false;
    }
}