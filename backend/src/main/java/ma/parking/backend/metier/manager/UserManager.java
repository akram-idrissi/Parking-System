package ma.parking.backend.metier.manager;


import com.fasterxml.jackson.databind.JsonNode;

import ma.parking.backend.dao.entities.User;
import org.springframework.stereotype.Component;


@Component
public interface UserManager {

    User getUser(Long id);
    boolean checkin(JsonNode request);
    boolean checkout(int id);
}
