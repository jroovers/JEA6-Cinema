package cinema.model.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingRequest {

    private Long showId;
    private String location;
    private String room;
    private String movietitle;
    private List<Integer> seats;

}
