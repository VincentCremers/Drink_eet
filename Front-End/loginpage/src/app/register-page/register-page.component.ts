import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  URL = "http://192.168.178.17:8080/api/add";
  register: FormGroup;

  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient) { 
    this.register = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      email: [''],
      password: ['']
    })
  }

  ngOnInit(): void {}

  onSubmit(): void {
    var formData: any = new FormData();
    formData.append("firstName", this.register.get('firstName').value);
    formData.append("lastName", this.register.get('lastName').value);
    formData.append("email", this.register.get('email').value);
    formData.append("password", this.register.get('password').value);

    this.httpClient.post<any>(this.URL, formData).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    )
  }
}
