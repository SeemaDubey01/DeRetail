package com.deretail.repo;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.deretail.dto.BrandMaster;

public interface BrandMasterRepo extends JpaRepository<BrandMaster, BigDecimal>{

	List<BrandMaster> findByBrandContains(String brand);
	
	List<BrandMaster> findByProdNameContains(String name);
}
