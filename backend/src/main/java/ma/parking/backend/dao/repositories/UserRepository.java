package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User  findUserById(Long id);
    User  findUserByUsername(String name);
    List<User> findAllBy();
}
