import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  URL = "http://192.168.178.44:8080/api/authenticate";
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
    var formData: any = new FormData();
    formData.append("username", this.login.get('username').value);
    formData.append("password", this.login.get('password').value);

    this.httpClient.post<any>(this.URL, formData).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    )
  }
}
