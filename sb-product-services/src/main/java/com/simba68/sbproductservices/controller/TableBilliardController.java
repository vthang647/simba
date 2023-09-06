package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.TableBilliard;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.TableBilliardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/TableBilliard")
public class TableBilliardController {
    private final ResponseFactory responseFactory;
    private final AdapterM<TableBilliard> tableBilliardAdapterM;
    private final TableBilliardRepo tableBilliardRepo;
    
    @GetMapping
    public ResponseEntity<?> getTableBilliardByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( tableBilliardAdapterM.adapter(tableBilliardRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TableBilliard tableBilliard){
        return responseFactory.success( tableBilliardAdapterM.save(tableBilliardRepo, tableBilliard), TableBilliard.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody TableBilliard tableBilliard){
        return responseFactory.success( tableBilliardAdapterM.save(tableBilliardRepo, tableBilliard), TableBilliard.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        tableBilliardAdapterM.delete(tableBilliardRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
