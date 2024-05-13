package ma.parking.backend.web;


import ma.parking.backend.dao.entities.*;
import ma.parking.backend.metier.manager.SlotManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.format.DateTimeFormatter;


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
    public ResponseEntity<Map<String, Boolean>> checkin(@RequestBody JsonNode request) {
        JsonNode reqParams = request.get("params");
        JsonNode reqUser = request.get("user");
        JsonNode reqVehicle = request.get("vehicle");

        User user = new User(
                reqUser.get("username").asText(),
                reqUser.get("password").asText(),
                LocalDateTime.now()
        );

        Vehicle vehicle= new Vehicle(
                reqVehicle.get("brand").asText(),
                reqVehicle.get("model").asText(),
                reqVehicle.get("color").asText(),
                reqVehicle.get("plate").asText()
        );

        Slot slot = slotManager.getSlot(Integer.parseInt(reqParams.get("id").asText()));

        Reservation reservation = new Reservation(
                user,
                slot,
                LocalDateTime.parse(reqParams.get("checkin").asText(), DateTimeFormatter.ISO_DATE_TIME),
                LocalDateTime.parse(reqParams.get("checkout").asText(), DateTimeFormatter.ISO_DATE_TIME)
        );

        SVReservation svr = new SVReservation(
                vehicle,
                slot,
                LocalDateTime.parse(reqParams.get("checkin").asText(), DateTimeFormatter.ISO_DATE_TIME),
                LocalDateTime.parse(reqParams.get("checkout").asText(), DateTimeFormatter.ISO_DATE_TIME)
        );


        Map<String, Boolean> response = new HashMap<>();
        //response.put("slotReserved", slotReserved);

        return ResponseEntity.ok(response);
    }
}
