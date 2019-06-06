import { Movie } from './movie';
import { Room } from './room';
import { Theatre } from './theatre';

export class Show {
    id: number;
    movie: Movie;
    room: Room;
    theatre: Theatre;
    scheduledTime: Date;
}
