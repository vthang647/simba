package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.Bill;
import com.simba68.sbproductservices.entity.TableBilliard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableBilliardRepo extends JpaRepository<TableBilliard, Long> {
}
