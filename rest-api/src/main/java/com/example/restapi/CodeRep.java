package com.example.restapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CodeRep extends JpaRepository<Code, Integer> {

    boolean existsBycode(int code);



}
