package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import ma.parking.backend.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User  findUserById(int id);
    User  findUserByUsername(String name);
    List<User> findAll();
}
