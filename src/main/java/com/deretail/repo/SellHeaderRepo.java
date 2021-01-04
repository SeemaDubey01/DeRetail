package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deretail.dto.DeRetailSellHeader;

@Repository
public interface SellHeaderRepo extends JpaRepository<DeRetailSellHeader, Integer>  {

	@Query(value = "SELECT MAX(drshBillNo) FROM DeRetailSellHeader")
	public int findMaxBillNo();
}
