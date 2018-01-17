import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { Http, Response } from "@angular/http";
import { Course } from "../shared/Course.model";
import { AuthService } from "../auth/auth.service";

@Injectable()
export class HomeService {

    private _getCoursesURL = '../api/student/courses/';

    constructor(private _http: Http, private _authService: AuthService) {

    }
    getCourses(): Observable<Course[]> {
        return this._http.get(this._getCoursesURL + this._authService.token)
            .map(
            (response: Response) =>
                response.json()
            );
    }

}