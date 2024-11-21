package com.tcc.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.tcc.model.NoticiasModel;

public interface NoticiasRepository extends JpaRepository <NoticiasModel, Long> {

}
