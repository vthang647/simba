package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.BillDetails;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.BillDetailRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/BillDetails")
public class BillDetailController {
    private final ResponseFactory responseFactory;
    private final AdapterM<BillDetails> billDetailAdapter;
    private final BillDetailRepo billDetailRepo;
    
    @GetMapping
    public ResponseEntity<?> getBillDetailsByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( billDetailAdapter.adapter(billDetailRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody BillDetails BillDetails){
        return responseFactory.success( billDetailAdapter.save(billDetailRepo, BillDetails), BillDetails.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody BillDetails BillDetails){
        return responseFactory.success( billDetailAdapter.save(billDetailRepo, BillDetails), BillDetails.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        billDetailAdapter.delete(billDetailRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
