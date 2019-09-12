import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/services/booking.service';
import { SessionService } from 'src/app/services/session.service';
import { Router } from '@angular/router';
import { Show } from 'src/app/models/show';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {

  selectedShow: Show = null;
  selectedSeats: number[] = [];

  constructor(
    private bookingService: BookingService,
    public session: SessionService,
    private router: Router
  ) { }

  ngOnInit() {
    if (this.session.getShow()) {
      this.selectedShow = this.session.getShow();
    }
  }

  seat(int: number): boolean {
    return this.selectedShow.room.seats.includes(int);
  }

  toggleSeat(seat) {
    if (this.selectedSeats.includes(seat)) {
      this.selectedSeats.splice(this.selectedSeats.indexOf(seat), 1);
    }
    else {
      this.selectedSeats.push(seat);
    }
    console.log("picked a seat:");
    console.log(seat);
  }

  clearSeats() {
    console.log("reset picked seats");
    this.selectedSeats = [];
  }

  confirmBooking() {
    console.log("confirm picked seats");
    this.bookingService.sendBooking(this.session.getShow(), this.selectedSeats)
      .subscribe(result => {
        console.log(result)
        this.router.navigate(['/home']);
      });
  }
}
