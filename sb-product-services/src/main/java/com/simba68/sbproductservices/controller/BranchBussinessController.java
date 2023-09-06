package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.BranchBussiness;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.BranchBussinessRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/BranchBussiness")
public class BranchBussinessController {
    private final ResponseFactory responseFactory;
    private final AdapterM<BranchBussiness> branchBussinessAdapterM;
    private final BranchBussinessRepo branchBussinessRepo;
    
    @GetMapping
    public ResponseEntity<?> getBranchBussinessByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( branchBussinessAdapterM.adapter(branchBussinessRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody BranchBussiness BranchBussiness){
        return responseFactory.success( branchBussinessAdapterM.save(branchBussinessRepo, BranchBussiness), BranchBussiness.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody BranchBussiness BranchBussiness){
        return responseFactory.success( branchBussinessAdapterM.save(branchBussinessRepo, BranchBussiness), BranchBussiness.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        branchBussinessAdapterM.delete(branchBussinessRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
