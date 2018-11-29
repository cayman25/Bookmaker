package pl.bookmaker.demo.domain.model.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bookmaker.demo.domain.model.user.UserBets;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Game {

    @Id
    private int matchID;
    @JoinColumn(name = "Competition")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Competition competition;
    private String dateMatch;
    private String startTime;
    private String statusMatch;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Team homeTeam;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Team awayTeam;
    private String winner;
    @OneToMany(mappedBy = "game")
    private Set<UserBets> listBets;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean verifiedStatus;
}
