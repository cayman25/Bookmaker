/*
package pl.bookmaker.demo.repository;

import UserBetsDTO;
import UserBets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserBetsRepository extends JpaRepository<UserBets, Integer>, JpaSpecificationExecutor<UserBets> {

	@Override
	@Query("Select ub "
			+ "from UserBets ub "
			+ "inner join fetch ub.matchID")
	List<UserBets> findAll();

	@Query("Select new UserBetsDTO"
			+ "(ub.userID, ub.matchID.matchID, ub.matchID.homeTeam.teamName, ub.matchID.awayTeam.teamName, ub.userBet, ub.dateOfBet) "
			+ "from UserBets ub "
			+ "where ub.userID = :userID "
			+ "order by ub.betID")
	List<UserBetsDTO> getAllUserBets(@Param("userID") int userID);
	
	@Query("Select betID "
			+ "from UserBets ub "
			+ "where "
			+ "ub.userID = :userID "
			+ "AND "
			+ "ub.matchID.matchID = :matchID")
	Integer checkIfThisBetIsExist(@Param("userID") int userID, @Param("matchID")int matchID);

	Set<UserBets> findByMatchID_MatchID(int match);
}
*/
