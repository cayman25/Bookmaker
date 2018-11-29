package pl.bookmaker.demo.domain.model.entity;

import lombok.*;
<<<<<<< HEAD:src/main/java/pl/bookmaker/demo/domain/model/entity/user/User.java
import pl.bookmaker.demo.domain.model.entity.bets.UserBets;
import pl.bookmaker.demo.domain.model.entity.user.enums.Permission;
import pl.bookmaker.demo.infrastructure.account.factory.UserFactory;
=======
>>>>>>> parent of 0485692... changed infrastructure:src/main/java/pl/bookmaker/demo/domain/model/entity/User.java

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
<<<<<<< HEAD:src/main/java/pl/bookmaker/demo/domain/model/entity/user/User.java
  @JoinColumn(name = "userId")
  @OneToMany(cascade = CascadeType.ALL)
  private Set<UserPermission> permissions = new HashSet<>();
  @OneToMany(mappedBy = "user")
  List<UserBets> userBets;

=======

  @OneToMany(mappedBy = "user")
  List<UserBets> userBets;
>>>>>>> parent of 0485692... changed infrastructure:src/main/java/pl/bookmaker/demo/domain/model/entity/User.java
}

