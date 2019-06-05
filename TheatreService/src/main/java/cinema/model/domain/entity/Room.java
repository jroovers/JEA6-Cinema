package cinema.model.domain.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Room implements Serializable {

    @ManyToOne
    private Theatre theatre;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    @ElementCollection
    private List<Integer> seats;
    
    public void setTheatre(Theatre theatre){
        this.theatre = theatre;
        theatre.getAvailableRooms().add(this);
    }
}
