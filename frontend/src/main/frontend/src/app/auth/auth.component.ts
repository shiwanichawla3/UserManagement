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

  error: string = '';
  pageTitle: string = "Login";
  password: string = "";
  email: string = "";
  loading: boolean = false;

  login(): void {
    this.loading = true;
    this._authService.login(this.email, this.password)
      .subscribe(result => {
        if (result == true) {
          this.router.navigate(['/']);
        } else {
          this.error = 'Username or Password is incorrect';
          this.loading = false;
        }
      });
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
