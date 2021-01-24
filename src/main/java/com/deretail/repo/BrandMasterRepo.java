package com.deretail.repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deretail.dto.BrandMaster;

public interface BrandMasterRepo extends JpaRepository<BrandMaster, BigDecimal>{

}
