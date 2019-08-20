package com.example.restapi;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface TranRep extends CrudRepository<Transaction, Integer> {

    Optional <Transaction> findBycodeAndstatus(int code, String status);
}
