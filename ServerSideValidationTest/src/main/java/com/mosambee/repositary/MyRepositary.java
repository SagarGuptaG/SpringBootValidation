package com.mosambee.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mosambee.model.Client;

@Repository
public interface MyRepositary extends JpaRepository<Client, Integer>{

}
