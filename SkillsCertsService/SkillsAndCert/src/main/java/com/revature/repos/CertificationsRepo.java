package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Certifications;

@Repository
public interface CertificationsRepo extends JpaRepository<Certifications, Integer>{

}
