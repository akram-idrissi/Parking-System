package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import ma.parking.backend.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<User, Integer> {
    Slot findSlotByID(int id);
    Slot  findSlotByUser(User user);
    Slot  findSlotByVehicle(Vehicle vehicle);
    List<Slot> findAllSlots();
}
