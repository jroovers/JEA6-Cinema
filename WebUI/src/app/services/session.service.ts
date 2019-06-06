import { Injectable } from '@angular/core';
import { Show } from '../models/show';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private selectedShow: Show = null;

  constructor() { }

  getShow(): Show {
    return this.selectedShow;
  }

  setShow(show: Show) {
    this.selectedShow = show;
  }
}
