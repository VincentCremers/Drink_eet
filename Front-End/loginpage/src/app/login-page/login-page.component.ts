import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  URL = "http://localhost:8080/api/authenticate";
  login: FormGroup;

  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient) {
    this.login = this.formBuilder.group({
      username: [''],
      password: ['']
    })
   }

  ngOnInit(): void {
  }

  onSubmit(): void {
    let login = "".concat(this.login.get('username').value, ",", this.login.get('password').value)
    
    this.httpClient.post<any>(this.URL,login ).subscribe(
      (res) => this.onResponse(res),
      (err) => console.log(err)
    )
  }

  onResponse(res: string): void{
    localStorage.setItem('id_token', res);
    console.log(res)
  }

}
