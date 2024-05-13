package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.SVReservation;
import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SVReservationRepository extends JpaRepository<SVReservation, Integer> {
    SVReservation findSVReservationByCheckinDateBefore(LocalDateTime date);
    SVReservation  findSVReservationByCheckoutDateAfter(LocalDateTime date);
    SVReservation findSVReservationByUser(User user);
    SVReservation findSVReservationBySlot(Slot slot);
    SVReservation findSVReservationByUserAndSlot(User user, Slot slot);
    List<SVReservation> findAll();
}
