package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.Bill;
import com.simba68.sbproductservices.entity.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepo extends JpaRepository<Combo, Long> {
}
