package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
    Slot findSlotById(int id);
    List<Slot> findAll();
}
