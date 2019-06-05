package cinema.model.domain.entity;

import cinema.model.domain.dto.Movie;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Embedded;
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
public class Show implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private Movie movie;
    @ManyToOne
    private Room room;
    private ZonedDateTime scheduledTime;
}
