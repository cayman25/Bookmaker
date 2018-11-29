package pl.bookmaker.demo.domain.model.entity.user;

import lombok.*;
import pl.bookmaker.demo.domain.model.entity.bets.UserBets;
import pl.bookmaker.demo.domain.model.entity.user.enums.Permission;
import pl.bookmaker.demo.infrastructure.account.factory.UserFactory;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  private int userId;
  private String password;
  @Email
  private String email;
  private String firstName;
  private String lastName;
  @JoinColumn(name = "userId")
  @OneToMany(cascade = CascadeType.ALL)
  private Set<UserPermission> permissions = new HashSet<>();
  @OneToMany(mappedBy = "user")
  List<UserBets> userBets;

}

