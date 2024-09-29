import {Component} from '@angular/core';
import {ShopModel} from "../shop-model/shop-model";
import {ShopService} from "../shop-service/shop.service";
import {ItemModel} from "../shop-model/item-model";
import {StockModel} from "../shop-model/stock-model";

@Component({
  selector: 'app-shop-list',
  templateUrl: './shop-list.component.html',
  styleUrls: ['./shop-list.component.scss']
})
export class ShopListComponent {
  shops: ShopModel[] = [];
  items: ItemModel[] = [];
  stocks: StockModel[] = [];

  constructor(private shopService: ShopService) {
  }

  ngOnInit() {
    this.shopService.findAll().subscribe(data => {
      this.shops = data;
    });
    this.shopService.findAllItems().subscribe(data => {
      this.items = data;
    });
    this.shopService.findAllStocks().subscribe(data => {
      this.stocks = data;
    });
  }

  ngAfterContentInit() {
    this.shops = this.shops.map(shop => {
      const relatedItem = this.stocks.find(shopItem => shopItem.shop_id === shop.id);

      const item = this.items.find(i => i.id === relatedItem?.item_id);

      return {
        ...shop,
        item: item
      };
    });
  }
}
