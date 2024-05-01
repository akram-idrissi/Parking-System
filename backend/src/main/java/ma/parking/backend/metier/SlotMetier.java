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
        return slotRepository.findAll();
    }

    @Override
    public boolean checkin(int id) {
        Slot slot = slotRepository.findSlotById(id);

        if (slot.getStatus().equals(Slot.STATUS.BUSY))
            return false;

        slot.setStatus(Slot.STATUS.BUSY);
        slotRepository.save(slot);

        return true;
    }

    @Override
    public boolean checkout(int id) {
        Slot slot = slotRepository.findSlotById(id);
        slot.setStatus(Slot.STATUS.AVAILABLE);
        slot.setVehicle(null);
        slotRepository.save(slot);

        return true;
    }
}
