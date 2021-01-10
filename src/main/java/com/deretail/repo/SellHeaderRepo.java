package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deretail.dto.SellHeader;

@Repository
public interface SellHeaderRepo extends JpaRepository<SellHeader, Integer>  {

	@Query(value = "SELECT MAX(billNo) FROM SellHeader")
	public int findMaxBillNo();
}
