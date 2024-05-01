package ma.parking.backend.web;


import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.metier.manager.SlotManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SlotController {

    @Autowired
    private SlotManager slotManager;

    @GetMapping("/slots")
    public ResponseEntity<Map<String, List<Slot>>> slots() {
        Map<String, List<Slot>> response = new HashMap<>();

        response.put("slots", slotManager.getAllSlots());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/checkin")
    public ResponseEntity<Map<String, Boolean>> checkin(@RequestParam(name = "slot_id") Integer id) {
        Map<String, Boolean> response = new HashMap<>();
        boolean slotReserved = slotManager.checkin(id);

        response.put("slotReserved", slotReserved);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/checkin")
    public ResponseEntity<Map<String, Boolean>> checkout(@RequestParam(name = "slot_id") Integer id) {
        Map<String, Boolean> response = new HashMap<>();
        boolean slotAvailable = slotManager.checkout(id);

        response.put("slotAvailable", slotAvailable);
        return ResponseEntity.ok(response);
    }

}
