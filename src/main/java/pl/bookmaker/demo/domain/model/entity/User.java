package pl.bookmaker.demo.domain.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
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

