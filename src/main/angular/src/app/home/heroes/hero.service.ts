import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hero} from "./hero";

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/home/heroes';
  }

  public findAll(): Observable<Hero[]> {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization':  temp});
    return this.http.get<Hero[]>(this.usersUrl, {headers: headers});
  }
  public save(hero: Hero) {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization':  temp});
    return this.http.post<Hero>(this.usersUrl, hero, {headers: headers});
  }
}
