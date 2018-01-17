import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";
import { Http } from "@angular/http";

@Injectable()
export class HomeService {

    constructor(private _http: Http) {

    }
}