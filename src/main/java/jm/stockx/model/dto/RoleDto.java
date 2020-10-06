package jm.stockx.model.dto;

import jm.stockx.model.entity.Role;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;

    @NotBlank
    private String name;

    public RoleDto(Role role) {
        this.name = role.getRoleName();
    }
}
