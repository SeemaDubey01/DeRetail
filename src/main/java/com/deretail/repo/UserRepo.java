package com.deretail.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deretail.dto.DeRetailUsers;

public interface UserRepo extends JpaRepository<DeRetailUsers, String> {

}
