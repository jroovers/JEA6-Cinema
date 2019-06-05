package cinema.model.domain.dto;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Movie {

    public Movie(String title, Integer releaseYear, Integer playtime) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.playtime = playtime;
    }

    private Long id;
    private String title;
    private Integer playtime;
    private Integer releaseYear;
}
