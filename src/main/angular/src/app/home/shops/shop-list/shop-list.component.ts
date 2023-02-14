import {Component} from '@angular/core';
import {ShopModel} from "../shop-model/shop-model";
import {ShopService} from "../shop-service/shop.service";

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.scss']
})
export class ShopListComponent {
  shops: ShopModel[] = [];

  constructor(private shopService: ShopService) {
  }

  ngOnInit() {
    this.shopService.findAll().subscribe(data => {
      this.shops = data;
    });
  }
}
