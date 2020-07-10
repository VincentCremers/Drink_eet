import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {HomeComponent} from "../home";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  URL = "http://localhost:8080/api/authenticate";
  login: FormGroup;
  returnUrl: string;


  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private route: ActivatedRoute, private router: Router) {
    this.login = this.formBuilder.group({
      username: [''],
      password: ['']
    })
    if (localStorage.getItem('JWT_TOKEN') !== null) {
      this.router.navigate(['/']);
    }
   }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  onSubmit(): void {
    let login = "".concat(this.login.get('username').value, ",", this.login.get('password').value)

    this.httpClient.post<any>(this.URL,login ).subscribe(
      (res) => this.onResponse(res),
      (err) => console.log(err)
    )
  }

  onResponse(res: string): void{
    console.log(res)
    localStorage.setItem('JWT_TOKEN', res.toString());
    this.router.navigate(['/home-page']);
  }

  get f() { return this.login.controls; }

}
