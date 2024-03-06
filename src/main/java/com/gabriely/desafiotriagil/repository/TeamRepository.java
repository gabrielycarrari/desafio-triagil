package com.gabriely.desafiotriagil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gabriely.desafiotriagil.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

    @Transactional(readOnly = true)
    List<Team> findByOwner(String owner);
}
