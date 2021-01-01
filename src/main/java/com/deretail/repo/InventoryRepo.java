package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deretail.dto.DeRetailInventory;

public interface InventoryRepo extends JpaRepository<DeRetailInventory, Integer>{

}
