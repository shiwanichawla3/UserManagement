import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
import { Course } from '../shared/Course.model';

@Component({
    moduleId: module.id,
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
    pageTitle: string ="Home Page";
    courses: Course[] = [];

    constructor(private _homeService: HomeService) { }

    ngOnInit() {
        // get users from secure api end point
        this._homeService.getCourses()
            .subscribe(courses => {
                this.courses = courses;
            });
    }

}