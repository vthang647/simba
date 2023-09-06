package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Food;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/foods")
public class FoodController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Food> foodAdapterM;
    private final FoodRepo foodRepo;
    @GetMapping
    public ResponseEntity<?> getFoodByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( foodAdapterM.adapter(foodRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Food food){
        return responseFactory.success( foodAdapterM.save(foodRepo, food), Food.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Food food){
        return responseFactory.success( foodAdapterM.save(foodRepo, food), Food.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        foodAdapterM.delete(foodRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
