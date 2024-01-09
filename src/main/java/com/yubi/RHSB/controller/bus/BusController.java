package com.yubi.RHSB.controller.bus;

import com.yubi.RHSB.model.Bus;
import com.yubi.RHSB.service.bus.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/api/bus")
public class BusController {
    @Autowired
    BusService busService;


    @GetMapping("/getAllBus")
    public ResponseEntity<List<Bus>> getAllBus() {
        List<Bus> busList = busService.getAllBus();
        if(busList.size() > 0){
            return ResponseEntity.ok(busList);
        }
       return ResponseEntity.noContent().build();
    }

    @PostMapping("/addBus")
    public ResponseEntity<?> addBus(@RequestBody Bus bus){
        Bus newBus = null;
        try {
            newBus = busService.addBus(bus);
        } catch (Exception e) {
           return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
        return ResponseEntity.ok(newBus);
    }

    @PutMapping("/updateBus/{id}")
    public ResponseEntity<?> updateBus(@RequestBody Bus bus, @PathVariable String id){
        Bus newBus = null;
        try{
            newBus =  busService.updateBus(bus,id);
        } catch (Exception e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
        return ResponseEntity.ok(newBus);
    }
}

