package pl.bookmaker.demo.domain.model.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.bookmaker.demo.domain.model.entity.user.enums.Privilege;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table
@Entity
@ToString
@Getter
@EqualsAndHashCode(of = "userId")
@NoArgsConstructor
public class UserPrivilege {

    @Id
    private int userId;
    @Enumerated(EnumType.STRING)
    private Privilege privilege;

}
