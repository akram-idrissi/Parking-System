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
@Table(name = "Reservation")
public class Reservation implements Serializable {

    public Reservation(User user, Slot slot, LocalDateTime checkin, LocalDateTime checkout) {
        this.user = user;
        this.slot = slot;
        this.checkinDate = checkin;
        this.checkoutDate = checkout;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
