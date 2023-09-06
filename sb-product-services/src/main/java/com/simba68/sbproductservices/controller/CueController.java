package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Cue;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.CueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/cue")
public class CueController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Cue> CueAdapterM;
    private final CueRepo cueRepo;
    
    @GetMapping
    public ResponseEntity<?> getCueByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( CueAdapterM.adapter(cueRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cue Cue){
        return responseFactory.success( CueAdapterM.save(cueRepo, Cue), Cue.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cue Cue){
        return responseFactory.success( CueAdapterM.save(cueRepo, Cue), Cue.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        CueAdapterM.delete(cueRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
