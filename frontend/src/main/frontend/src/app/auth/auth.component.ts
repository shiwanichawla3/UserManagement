import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(private _authService: AuthService, private router: Router) {
  }

  error1: string = '';
  error2: string = '';
  pageTitle1: string = "Login";
  pageTitle2: string = "Register";
  password: string = "";
  email: string = "";
  registeremail: string = "";
  registerpassword: string = "";
  registername: string = "";
  loading: boolean = false;
  studentData: any = {};

  login(): void {
    this.error1 = this.error2 = "";
    this.loading = true;
    this._authService.login(this.email, this.password)
      .subscribe(result => {
        if (result == true) {
          this.router.navigate(['/']);
        } else {
          this.error1 = 'Username or Password is incorrect';
          this.loading = false;
        }
      },
      error => this.error1 = 'OOPS some backend error !! Please try again with correct data');
  }

  register(): void {
    this.error1 = this.error2 = "";
    this.loading = true;
    this._authService.register(this.registeremail, this.registername, this.registerpassword)
      .subscribe(result => {
        if (result == true) {
          this.router.navigate(['/']);
        } else {
          this.error2 = 'Invalid data.Please check email,name and password again';
          this.loading = false;
        }
      },
      error => this.error2 = 'OOPS some backend error !! Please try again with correct data');
  }

  logout(): void {
    this._authService.logout();
  }
  ngOnInit(): void {
    console.log('In onInit of Auth component');
    //reset login status
    this._authService.logout();
  }
}
