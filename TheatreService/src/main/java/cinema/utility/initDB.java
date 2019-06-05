package cinema.utility;

import cinema.model.dao.RoomDao;
import cinema.model.dao.ShowDao;
import cinema.model.dao.TheatreDao;
import cinema.model.domain.dto.Movie;
import cinema.model.domain.entity.Room;
import cinema.model.domain.entity.Show;
import cinema.model.domain.entity.Theatre;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@Startup
@Singleton
public class initDB {

    @Inject
    TheatreDao tdao;

    @Inject
    RoomDao rdao;

    @Inject
    ShowDao sdao;

    @PostConstruct
    public void init() {
        System.out.println("hello from initdb @ threatreservice");
        createTheatre();
        createRooms();
        createSchedule();
        System.out.println("initdb finished");
    }

    private void createTheatre() {
        Theatre cinema = new Theatre();
        cinema.setLocation("Eindhoven");
        tdao.create(cinema);
    }

    private void createRooms() {
        // There is only one cinema, so
        Theatre parent = tdao.findAll().get(0);
        Room room1 = new Room();
        room1.setName("Zaal 1");
        room1.setTheatre(parent);
        room1.setSeats(new ArrayList<>(15));
        addSomeSeats(room1);
        rdao.create(room1);

        Room room2 = new Room();
        room2.setName("Zaal 2");
        room2.setTheatre(parent);
        room2.setSeats(new ArrayList<>(15));
        addSomeSeats(room2);
        rdao.create(room2);

        Room room3 = new Room();
        room3.setName("Zaal 3");
        room3.setTheatre(parent);
        room3.setSeats(new ArrayList<>(15));
        addSomeSeats(room3);
        rdao.create(room3);
    }

    private void addSomeSeats(Room room) {
        for (int i = 1; i <= 15; i++) {
            room.getSeats().add(i);
        }
    }

    private void createSchedule() {
        Theatre parent = tdao.findAll().get(0);
        List<Movie> movies = movieServiceConnector.getAllMovies();
        int i = 0;
        for (Room r : rdao.findAll()) {
            Show show1 = new Show();
            show1.setTheatre(parent);
            show1.setRoom(r);
            GregorianCalendar time1 = new GregorianCalendar(2019, 5, 15, 19, 45, 00);
            show1.setScheduledTime(ZonedDateTime.ofInstant(time1.toInstant(), ZoneId.of("GMT")));
            show1.setMovie(movies.get(i));
            sdao.create(show1);
            i++;
            Show show2 = new Show();
            show2.setTheatre(parent);
            show2.setRoom(r);
            GregorianCalendar time2 = new GregorianCalendar(2019,5, 15, 21, 30, 00);
            show2.setScheduledTime(ZonedDateTime.ofInstant(time2.toInstant(), ZoneId.of("GMT")));
            show2.setMovie(movies.get(i));
            sdao.create(show2);
            i++;
        }

    }

}
