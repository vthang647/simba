package com.simba68.sbproductservices.repo;

import com.simba68.sbproductservices.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {
    Page<Food> findAllByFoodNameContains(String foodName, Pageable pageable);
}
