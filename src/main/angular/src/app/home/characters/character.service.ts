import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {World} from "../worlds/world";

@Injectable({
  providedIn: 'root'
})
export class CharacterService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/home/heroes';
  }

  public findAll(): Observable<World[]> {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization':  temp});
    return this.http.get<World[]>(this.usersUrl, {headers: headers});
  }

  public save(world: World) {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization':  temp});
    return this.http.post<World>(this.usersUrl, world, {headers: headers});
  }
}
