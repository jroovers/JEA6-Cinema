import { Component, OnInit } from '@angular/core';
import { Theatre } from 'src/app/models/theatre';
import { TheatreService } from 'src/app/services/theatre.service';
import { BookingService } from 'src/app/services/booking.service';
import { Show } from 'src/app/models/show';
import { SessionService } from 'src/app/services/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  title = 'Smeuige Vleessoort';
  theatres: Theatre[] = [];
  selectedTheatre: Theatre = null;

  shows: Show[] = [];


  constructor(
    private theatreService: TheatreService,
    public session: SessionService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getTheatres();
  }

  getTheatres(): void {
    this.theatreService.getTheatres().subscribe(
      result => this.theatres = result
    );
  }

  getSchedule(): void {
    this.theatreService.getSchedule(this.selectedTheatre).subscribe(
      result => this.shows = result
    );
  }

  theatreSelected(selected: Theatre) {
    console.log("selected a theatre");
    console.log(selected);
    this.selectedTheatre = selected;
    this.getSchedule();
  }

  showSelected(selected: Show) {
    console.log("selected a show");
    console.log(selected);
    this.session.setShow(selected);
  }

  clearShow() {
    console.log("cleared show choice")
    this.session.setShow(null);
  }

  confirmBooking(){
    this.router.navigateByUrl("/booking")
  }

}
