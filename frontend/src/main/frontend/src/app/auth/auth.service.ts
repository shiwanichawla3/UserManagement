import { Injectable } from "@angular/core";
import { Http, Headers, Response } from "@angular/http";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map'

@Injectable()
export class AuthService {
    public token: string;

    private _authenticationURL = '../api/login';
    private _registrationURL = '../api/register';

    constructor(private _http: Http) {
        // set token if saved in local storage
        var currentStudent = JSON.parse(localStorage.getItem('currentStudent'));
        this.token = currentStudent && currentStudent.token;
    }
    login(email: string, password: string): Observable<boolean> {
        let headers = new Headers({ 'Content-Type': 'application/json' });

        return this._http.post(this._authenticationURL, JSON.stringify({ email: email, password: password }), { headers: headers })
            .map((response: Response) => {
                // login successful if there is a token in response 
                let token = response.text() && response.json();
                if (token) {
                    // set token property
                    this.token = token;

                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentStudent', JSON.stringify({ email: email, token: token }));

                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            });
    }

    register(email: string, name: string, password: string): Observable<boolean> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        return this._http.post(this._registrationURL, JSON.stringify({ email: email, name: name, password: password }), { headers: headers })
            .map((response: Response) => {
                // login successful if there is a token in response 
                let token = response.text() && response.json();
                if (token) {
                    // set token property
                    this.token = token;

                    // store username and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentStudent', JSON.stringify({ email: email, token: token }));

                    // return true to indicate successful login
                    return true;
                } else {
                    // return false to indicate failed login
                    return false;
                }
            });
    }

    logout(): void {
        // clear token remove user from local storage to log user out
        this.token = null;
        localStorage.removeItem('currentStudent');
    }
}