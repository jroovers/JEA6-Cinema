import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';
import { BookingRequest } from '../dto/bookingrequest';
import { Show } from '../models/show';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }

  sendBooking(show: Show, seats: number[]): Observable<any> {
    const url = `${environment.BookingAPI}bookings`;
    console.log("Attempting API call to:");
    console.log(url);
    let body: BookingRequest = new BookingRequest();
    body.showId = show.id;
    body.location = show.theatre.location;
    body.room = show.room.name;
    body.movietitle = show.movie.title;
    body.seats = seats;
    console.log(body);
    return this.http.post(url, body)
      .pipe(
        catchError(this.handleError<any>('getTheatres', []))
      );
  }

  /**
  * Handle Http operation that failed.
  * Let the app continue.
  * @param operation - name of the operation that failed
  * @param result - optional value to return as the observable result
  */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
