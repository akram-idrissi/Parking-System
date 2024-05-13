package ma.parking.backend.dao.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@Table(name = "SlotVehicleReservation")
public class SVReservation implements Serializable {

    public SVReservation(Vehicle vehicle, Slot slot, LocalDateTime checkin, LocalDateTime checkout) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.checkinDate = checkin;
        this.checkoutDate = checkout;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_plate", referencedColumnName = "plate")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @CreatedDate
    @Column(name = "checkin_date")
    private LocalDateTime checkinDate;

    @CreatedDate
    @Column(name = "checkout_date")
    private LocalDateTime checkoutDate;
}
