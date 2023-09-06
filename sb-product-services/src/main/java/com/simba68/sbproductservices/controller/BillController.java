package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Bill;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.BillRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/Bill")
public class BillController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Bill> BillAdapterM;
    private final BillRepo billRepo;
    
    @GetMapping
    public ResponseEntity<?> getBillByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( BillAdapterM.adapter(billRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Bill Bill){
        return responseFactory.success( BillAdapterM.save(billRepo, Bill), Bill.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Bill Bill){
        return responseFactory.success( BillAdapterM.save(billRepo, Bill), Bill.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        BillAdapterM.delete(billRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
