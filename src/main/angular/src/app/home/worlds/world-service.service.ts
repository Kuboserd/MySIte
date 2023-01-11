import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {World} from "./world";

@Injectable({
  providedIn: 'root'
})
export class WorldServiceService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/home/worlds';
  }

  public findAll(): Observable<World[]> {
    return this.http.get<World[]>(this.usersUrl, );
  }

  public save(world: World) {
    return this.http.post<World>(this.usersUrl, world);
  }

}
