package cinema.model.domain.entity;

import java.io.Serializable;
import java.util.List;
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
    private List<Integer> seats;
}