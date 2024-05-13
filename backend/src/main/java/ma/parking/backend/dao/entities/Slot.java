package ma.parking.backend.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@Table(name = "Slot")
public class Slot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "vehicle_plate")
//    private Vehicle vehicle;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private STATUS status;

//    @OneToMany(mappedBy = "slot")
//    private List<Reservation> userSlots = new ArrayList<>();

    public enum STATUS {
        AVAILABLE, BUSY
    }
}
