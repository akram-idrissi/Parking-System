package ma.parking.backend.dao.entities;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@Table(name = "Vehicles")
public class Vehicle implements Serializable {

    @Column(name = "brand", nullable = false)
    private String brand;

    @Id
    @Column(name = "plate", nullable = false, unique = true)
    private String plate;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "color", nullable = false)
    private String color;
}
