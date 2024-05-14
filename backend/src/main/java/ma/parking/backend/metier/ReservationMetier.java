package ma.parking.backend.metier;

import ma.parking.backend.dao.entities.*;
import ma.parking.backend.dao.repositories.SlotRepository;
import ma.parking.backend.metier.manager.SlotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class SlotMetier implements SlotManager {

    @Autowired
    private SlotRepository slotRepository;

    public Slot getSlot(int id) {
        return slotRepository.findSlotById(id);
    }
    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @Override
    public List<Slot> getFreeSlots() {


        return null;
    }
}
