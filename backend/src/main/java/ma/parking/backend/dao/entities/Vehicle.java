package ma.parking.backend.dao.entities;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@Table(name = "Vehicles")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand", nullable = false, length = 200)
    private String brand;

    @Column(name = "plate", nullable = false, unique = true, length = 200)
    private String plate;

    @Column(name = "model", nullable = false, length = 200)
    private String model;

    @Column(name = "color", nullable = false, length = 200)
    private String color;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private Slot slot;
}
