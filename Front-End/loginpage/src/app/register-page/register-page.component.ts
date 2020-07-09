import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  URL = "http://192.168.178.44:8080/api/add";
  register: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient) { 
    this.register = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit(): void {}

  onSubmit(): void {
    this.submitted = true;
    
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

  get f() { return this.register.controls; }
}
