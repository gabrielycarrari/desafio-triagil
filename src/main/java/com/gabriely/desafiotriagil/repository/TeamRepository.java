package com.gabriely.desafiotriagil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriely.desafiotriagil.model.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Long>{

}
