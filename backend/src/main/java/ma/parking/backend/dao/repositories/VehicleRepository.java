package ma.parking.backend.dao.repositories;

import ma.parking.backend.dao.entities.Slot;
import ma.parking.backend.dao.entities.User;
import ma.parking.backend.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findVehicleBySlot(Slot slot);

    Vehicle  findVehicleById(int id);
    Vehicle  findVehicleByBrand(String brand);
    List<Vehicle> findAll();
}
