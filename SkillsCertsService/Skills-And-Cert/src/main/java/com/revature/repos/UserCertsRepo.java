package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserCerts;

@Repository
public interface UserCertsRepo extends JpaRepository < UserCerts, Integer>{

}
