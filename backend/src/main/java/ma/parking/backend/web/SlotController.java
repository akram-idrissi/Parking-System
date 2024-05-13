package ma.parking.backend.web;


import ma.parking.backend.dao.entities.*;
import ma.parking.backend.metier.manager.SlotManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
