package com.mybookmaker.pl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybookmaker.pl.model.entity.UserBets;
import com.mybookmaker.pl.model.dto.UserBetsDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBetsRepository extends JpaRepository<UserBets, Integer>{

	@Query("Select new com.mybookmaker.pl.model.dto.UserBetsDTO"
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

	@Query("Select ub "
			+ "from UserBets ub "
			+ "where "
			+ "ub.matchID.matchID = :matchID")
	List<UserBets> getListOfMatchByMatchID (int matchID);

}
