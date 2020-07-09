import {Component} from '@angular/core';
import {first} from 'rxjs/operators';


@Component({templateUrl: 'home.component.html'})
export class HomeComponent {
  loading = false;
  naam: String;

  constructor() {
    this.naam = "Naam"
  }

}

