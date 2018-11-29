package pl.bookmaker.demo.domain.model.entity.user;

import lombok.*;
import pl.bookmaker.demo.domain.model.entity.user.enums.Permission;

import javax.persistence.*;
import java.util.UUID;

@Table
@Entity
@ToString
@Getter
@EqualsAndHashCode(of = "userId")
@NoArgsConstructor
@AllArgsConstructor
public class UserPermission {

    @Id
    private int userId;
    @Enumerated(EnumType.STRING)
    private Permission permission;


}
