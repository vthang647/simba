package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Beverage;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.BeverageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/beverage")
public class ComboController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Beverage> BeverageAdapterM;
    private final BeverageRepo beverageRepo;
    
    @GetMapping
    public ResponseEntity<?> getBeverageByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( BeverageAdapterM.adapter(beverageRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Beverage Beverage){
        return responseFactory.success( BeverageAdapterM.save(beverageRepo, Beverage), Beverage.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Beverage Beverage){
        return responseFactory.success( BeverageAdapterM.save(beverageRepo, Beverage), Beverage.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        BeverageAdapterM.delete(beverageRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
