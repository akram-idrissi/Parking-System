package ma.parking.backend.metier.manager;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface ReservationManager {

    List<Long> getBusySlots(LocalDateTime checkin, LocalDateTime checkout);
}
