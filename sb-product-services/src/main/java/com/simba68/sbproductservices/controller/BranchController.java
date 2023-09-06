package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Branches;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.BranchsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/Branches")
public class BranchController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Branches> branchesAdapterM;
    private final BranchsRepo branchsRepo;
    
    @GetMapping
    public ResponseEntity<?> getBranchesByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( branchesAdapterM.adapter(branchsRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Branches branches){
        return responseFactory.success( branchesAdapterM.save(branchsRepo, branches), Branches.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Branches branches){
        return responseFactory.success( branchesAdapterM.save(branchsRepo, branches), Branches.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        branchesAdapterM.delete(branchsRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
