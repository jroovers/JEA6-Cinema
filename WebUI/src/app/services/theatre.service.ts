import { Injectable } from '@angular/core';
import { Theatre } from '../models/theatre';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Show } from '../models/show';

@Injectable({
  providedIn: 'root'
})
export class TheatreService {

  constructor(private http: HttpClient) { }

  getTheatres(): Observable<Theatre[]> {
    const url = `${environment.TheatreAPI}theatres`;
    console.log("Attempting API call to:")
    console.log(url)
    return this.http.get<Theatre[]>(url)
      .pipe(
        catchError(this.handleError<Theatre[]>('getTheatres', []))
      );
  }

  getSchedule(theatre: Theatre): Observable<Show[]> {
    const url = `${environment.TheatreAPI}theatres/` + theatre.id + `/schedule`;
    console.log("Attempting API call to:")
    console.log(url)
    return this.http.get<Show[]>(url)
      .pipe(
        catchError(this.handleError<Show[]>('getSchedule', []))
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
