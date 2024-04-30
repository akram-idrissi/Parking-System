package ma.parking.backend.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@Table(name = "Slot")
public class Slot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private STATUS status;

    @OneToOne
    @JoinColumn(name = "vehicle_id")  // Add a foreign key column in the Slot table
    private Vehicle vehicle;

    @ManyToMany(mappedBy = "slots")
    private List<User> users = new ArrayList<>();

    public enum STATUS {
        AVAILABLE, BUSY
    }
}
