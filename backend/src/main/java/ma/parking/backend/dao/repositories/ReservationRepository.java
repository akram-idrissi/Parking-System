package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Reservation;
import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationByCheckinDateBefore(LocalDateTime date);

    Reservation findReservationByCheckoutDateAfter(LocalDateTime date);

    Reservation findReservationByUser(User user);

    Reservation findReservationBySlot(Slot slot);

    Reservation findReservationByUserAndSlot(User user, Slot slot);

    List<Reservation> findReservationsByCheckinDateAfterAndCheckoutDateBefore(LocalDateTime checkinDate, LocalDateTime checkoutDate);
}
