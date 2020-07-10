import {Component} from '@angular/core';
import {first} from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';



@Component({templateUrl: 'home.component.html'})
export class HomeComponent {
  loading = false;
  naam: String;

  constructor(private router: Router) {
    if (localStorage.getItem('JWT_TOKEN') === null) {
      this.router.navigate(['/login-page']);
    }
    this.naam = "Naam"
  }

}

