package cinema.utility;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Jeroen Roovers <jroovers>
 */
@Startup
@Singleton
public class initDB {

    @PostConstruct
    public void init() {
        
    }

}
