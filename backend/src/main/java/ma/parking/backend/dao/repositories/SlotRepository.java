package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import ma.parking.backend.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
    Slot findSlotById(int id);
    Slot  findSlotByVehicle(Vehicle vehicle);
    List<Slot> findAll();
}
