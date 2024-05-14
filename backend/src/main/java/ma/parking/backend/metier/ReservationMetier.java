package ma.parking.backend.metier;

import ma.parking.backend.dao.entities.Reservation;
import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.repositories.ReservationRepository;
import ma.parking.backend.metier.manager.ReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ReservationMetier implements ReservationManager {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Long> getBusySlots(LocalDateTime checkin, LocalDateTime checkout) {
        return reservationRepository.findReservationsByCheckinDateAfterAndCheckoutDateBefore(checkin, checkout)
                .stream().map(Reservation::getSlot)
                .map(Slot::getId)
                .toList();
    }
}
