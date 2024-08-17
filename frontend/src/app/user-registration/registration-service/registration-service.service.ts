import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../../user-model/user";

@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  private loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl='http://localhost:8080/registration';
  }


  public register(user: User) {
    return this.http.post<User>(this.loginUrl, user);
  }
}
