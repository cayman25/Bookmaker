package pl.bookmaker.demo.domain.model.user;

import lombok.*;
import pl.bookmaker.demo.domain.model.bets.UserBets;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@EqualsAndHashCode(of = "userId")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String password;
    @Email
    private String email;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user")
    List<UserBets> userBets;

}

