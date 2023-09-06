package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.Bill;
import com.simba68.sbproductservices.entity.Cue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CueRepo extends JpaRepository<Cue, Long> {
}
