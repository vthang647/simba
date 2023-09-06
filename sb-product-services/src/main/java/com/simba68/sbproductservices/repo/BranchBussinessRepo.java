package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.BranchBussiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchBussinessRepo extends JpaRepository<BranchBussiness, Long> {
}
