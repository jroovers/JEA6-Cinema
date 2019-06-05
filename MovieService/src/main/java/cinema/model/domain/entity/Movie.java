package cinema.model.domain.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "movie.getMovieById",
            query = "SELECT m FROM Movie m WHERE m.id = :id")
    ,
    @NamedQuery(name = "movie.getAllMovies",
            query = "SELECT m FROM Movie m")
})
public class Movie implements Serializable {

    public Movie(String title, Integer releaseYear, Integer playtime) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.playtime = playtime;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer playtime;
    private Integer releaseYear;

}
