package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deretail.dto.SellDetails;

@Repository
public interface SellDetailsRepo extends JpaRepository<SellDetails, String>{

}
