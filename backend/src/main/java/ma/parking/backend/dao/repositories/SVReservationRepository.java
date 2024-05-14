package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.SVReservation;
import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import ma.parking.backend.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SVReservationRepository extends JpaRepository<SVReservation, Integer> {
    SVReservation findSVReservationByCheckinDateBefore(LocalDateTime date);
    SVReservation  findSVReservationByCheckoutDateAfter(LocalDateTime date);
    SVReservation findSVReservationByVehicle(Vehicle vehicle);
    SVReservation findSVReservationBySlot(Slot slot);
    SVReservation findSVReservationByVehicleAndSlot(Vehicle vehicle, Slot slot);
    List<SVReservation> findAll();
}
