import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {ShopModel} from "../shop-model/shop-model";
import {ItemModel} from "../shop-model/item-model";
import {StockModel} from "../shop-model/stock-model";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/home/shops';
  }

  public findAll(): Observable<ShopModel[]> {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization': temp});
    return this.http.get<ShopModel[]>(this.usersUrl, {headers: headers});
  }

  public findAllItems(): Observable<ItemModel[]> {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization': temp});
    return this.http.get<ItemModel[]>(this.usersUrl, {headers: headers});
  }

  public findAllStocks(): Observable<StockModel[]> {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization': temp});
    return this.http.get<StockModel[]>(this.usersUrl, {headers: headers});
  }

  public save(shop: ShopModel) {
    let temp = "Bearer " + (<string>sessionStorage.getItem('token'));
    const headers = new HttpHeaders({'Authorization': temp});
    return this.http.post<ShopModel>(this.usersUrl, shop, {headers: headers});
  }

}
