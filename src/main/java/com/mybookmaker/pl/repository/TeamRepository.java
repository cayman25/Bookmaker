package com.mybookmaker.pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmaker.pl.model.entity.Team;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
}
