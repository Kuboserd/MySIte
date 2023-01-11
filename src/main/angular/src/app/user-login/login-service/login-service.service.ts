import { Injectable } from '@angular/core';
import {User} from "../../user-model/user";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl='http://localhost:8080/login';
  }


  public login(user: User) {
    return this.http.post<User>(this.loginUrl, user);
  }
}
