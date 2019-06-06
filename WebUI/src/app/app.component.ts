import { Component, OnInit } from '@angular/core';
import { TheatreService } from './services/theatre.service';
import { BookingService } from './services/booking.service';
import { Theatre } from './models/theatre';
import { Show } from './models/show';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = "Smeuige, smeerbare vleessoort"
}
