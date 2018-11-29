package pl.bookmaker.demo.domain.model.user;

import lombok.*;
import pl.bookmaker.demo.domain.model.bets.UserBets;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@EqualsAndHashCode(of = "userId")
public class User {

    @Id
    private int userId;
    private String password;
    @Email
    private String email;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user")
    List<UserBets> userBets;

}

