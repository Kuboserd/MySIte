import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {ItemModel} from "../shop-model/item-model";

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    //TODO see bellow
    this.usersUrl = 'http://localhost:8080/home/???';
  }

  public findAll(): Observable<ItemModel[]> {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization':  temp});
    return this.http.get<ItemModel[]>(this.usersUrl, {headers: headers});
  }

}
