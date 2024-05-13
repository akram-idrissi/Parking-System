package ma.parking.backend.metier.manager;


import ma.parking.backend.dao.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SlotManager {

    Slot getSlot(int id);
    List<Slot> getAllSlots();
}
