package com.simba68.sbproductservices.controller;

import com.simba68.sbproductservices.adapter.AdapterM;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Room;
import com.simba68.sbproductservices.factory.ResponseFactory;
import com.simba68.sbproductservices.repo.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/simba/v1/room")
public class RoomController {
    private final ResponseFactory responseFactory;
    private final AdapterM<Room> roomAdapterM;
    private final RoomRepo roomRepo;
    
    @GetMapping
    public ResponseEntity<?> getRoomByOptions(@RequestBody OptionGetDataDTO option){
        return responseFactory.success( roomAdapterM.adapter(roomRepo, option), List.class );
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Room room){
        return responseFactory.success( roomAdapterM.save(roomRepo, room), Room.class );
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Room room){
        return responseFactory.success( roomAdapterM.save(roomRepo, room), Room.class );
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id){
        roomAdapterM.delete(roomRepo, id);
        return responseFactory.success("Delete ok!", String.class);
    }
}
