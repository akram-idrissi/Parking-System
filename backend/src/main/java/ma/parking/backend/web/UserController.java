package ma.parking.backend.web;


import com.fasterxml.jackson.databind.JsonNode;
import ma.parking.backend.dao.entities.*;
import ma.parking.backend.metier.manager.UserManager;
import ma.parking.backend.metier.manager.SlotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    private UserManager userManager;

    @PostMapping("/checkin")
    public ResponseEntity<Map<String, Boolean>> checkin(@RequestBody JsonNode request) {
        boolean success = userManager.checkin(request);
        Map<String, Boolean> response = new HashMap<>();
        response.put("checkinDone", success);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Map<String, Boolean>> checkout(@RequestParam(name = "slot_id") Integer id) {
        Map<String, Boolean> response = new HashMap<>();
        boolean success = userManager.checkout(id);
        response.put("checkoutDone", success);
        return ResponseEntity.ok(response);
    }
}
