import {Component} from '@angular/core';
import {ShopModel} from "../shop-model/shop-model";
import {ShopService} from "../shop-service/shop.service";
import {ItemModel} from "../shop-model/item-model";

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.scss']
})
export class ShopListComponent {
  shops: ShopModel[] = [];
  items: ItemModel[] = [];

  constructor(private shopService: ShopService) {
  }

  ngOnInit() {
    this.shopService.findAll().subscribe(data => {
      this.shops = data;
    });
  }
}
