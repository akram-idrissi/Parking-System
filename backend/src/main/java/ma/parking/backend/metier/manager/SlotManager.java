package ma.parking.backend.metier.manager;


import ma.parking.backend.dao.entities.Slot;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SlotManager {

    List<Slot> getAllSlots();

    boolean checkin(int id);
    boolean checkout(int id);
}
