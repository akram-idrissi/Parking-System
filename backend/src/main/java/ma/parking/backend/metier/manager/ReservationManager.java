package ma.parking.backend.metier.manager;


import ma.parking.backend.dao.entities.Slot;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface SlotManager {

    Slot getSlot(int id);
    List<Slot> getAllSlots();
    List<Slot> getFreeSlots();
}
