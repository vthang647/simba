package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepo extends JpaRepository<Beverage, Long> {
}
