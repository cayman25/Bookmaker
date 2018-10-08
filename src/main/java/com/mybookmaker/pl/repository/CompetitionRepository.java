package com.mybookmaker.pl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmaker.pl.model.entity.Competition;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer>{

}
