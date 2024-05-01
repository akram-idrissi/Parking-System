package ma.parking.backend.metier;

import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.repositories.SlotRepository;
import ma.parking.backend.metier.manager.SlotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SlotMetier implements SlotManager {

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.findAllSlots();
    }

    @Override
    public boolean checkin(int id) {
        Slot slot = slotRepository.findSlotByID(id);

        if (slot.getStatus().equals(Slot.STATUS.BUSY))
            return false;

        slot.setStatus(Slot.STATUS.BUSY);

        return true;
    }

    @Override
    public boolean checkout(int id) {
        Slot slot = slotRepository.findSlotByID(id);

        if (slot.getStatus().equals(Slot.STATUS.AVAILABLE))
            return false;

        slot.setStatus(Slot.STATUS.AVAILABLE);
        slot.setVehicle(null);

        return true;
    }
}
