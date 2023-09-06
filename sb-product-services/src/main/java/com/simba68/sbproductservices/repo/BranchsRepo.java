package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.Bill;
import com.simba68.sbproductservices.entity.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchsRepo extends JpaRepository<Branches, Long> {
}
