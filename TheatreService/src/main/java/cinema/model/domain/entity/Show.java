package cinema.model.domain.entity;

import cinema.model.domain.dto.Movie;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    @ManyToOne
    private Theatre theatre;

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "id", column = @Column(name = "movie_id"))
        ,
        @AttributeOverride(name = "title", column = @Column(name = "movie_title"))
    })
    private Movie movie;
    @OneToOne
    private Room room;
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime scheduledTime;

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
        theatre.getSchedule().add(this);
    }
}
