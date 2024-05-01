package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import ma.parking.backend.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User  findUserByID(int id);
    User  findUserByName(String name);
    User  findUserByVehicle(Vehicle vehicle);
    User  findUserBySlot(Slot slot);
    List<User> findAllUsers();
}
