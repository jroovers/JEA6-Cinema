package cinema.model.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jeroen Roovers
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Theatre implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String location;
    @JsonbTransient
    @OneToMany(mappedBy = "theatre")
    private List<Room> availableRooms;
    @JsonbTransient
    @OneToMany(mappedBy = "theatre")
    private List<Show> schedule;

}
