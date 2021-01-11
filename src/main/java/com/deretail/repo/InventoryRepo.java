package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deretail.dto.InventoryMaster;

public interface InventoryRepo extends JpaRepository<InventoryMaster, Integer>{

}
