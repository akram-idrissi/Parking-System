package ma.parking.backend.metier;

import com.fasterxml.jackson.databind.JsonNode;
import ma.parking.backend.dao.entities.*;
import ma.parking.backend.dao.repositories.*;
import ma.parking.backend.metier.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class UserMetier implements UserManager {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private SVReservationRepository svrRepository;

    public User getUser(Long id) {
        return userRepository.findUserById(id);
    }

    public boolean checkin(JsonNode request) {
        JsonNode reqParams = request.get("params");
        JsonNode reqUser = request.get("user");
        JsonNode reqVehicle = request.get("vehicle");

        User user = new User(
                reqUser.get("username").asText(),
                reqUser.get("password").asText(),
                LocalDateTime.now()
        );

        Vehicle vehicle = new Vehicle(
                reqVehicle.get("brand").asText(),
                reqVehicle.get("plate").asText(),
                reqVehicle.get("model").asText(),
                reqVehicle.get("color").asText()
        );

        Slot slot = slotRepository.findById(Integer.parseInt(reqParams.get("id").asText())).orElse(null);
        if (slot == null || slot.getStatus() != Slot.STATUS.AVAILABLE) {
            return false;
        }

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

        userRepository.save(user);
        vehicleRepository.save(vehicle);
        reservationRepository.save(reservation);
        svrRepository.save(svr);

        slot.setStatus(Slot.STATUS.BUSY);
        slotRepository.save(slot);

        return true;
    }

    @Override
    public boolean checkout(int id) {
        Slot slot = slotRepository.findById(id).orElse(null);
        if (slot != null) {
            slot.setStatus(Slot.STATUS.AVAILABLE);
            slotRepository.save(slot);
            return true;
        }
        return false;
    }

}
