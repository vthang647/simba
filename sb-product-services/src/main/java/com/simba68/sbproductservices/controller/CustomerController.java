package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Beverage;
import com.simba68.sbproductservices.entity.Customers;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.BeverageRepo;
import com.simba68.sbproductservices.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/customers")
public class CustomerController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Customers> customersAdapterM;
    private final CustomerRepo customerRepo;
    
    @GetMapping
    public ResponseEntity<?> getBeverageByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( customersAdapterM.adapter(customerRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customers customer){
        return responseFactory.success( customersAdapterM.save(customerRepo, customer), Customers.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Customers customer){
        return responseFactory.success( customersAdapterM.save(customerRepo, customer), Customers.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        customersAdapterM.delete(customerRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
