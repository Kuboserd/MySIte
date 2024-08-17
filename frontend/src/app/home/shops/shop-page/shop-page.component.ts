import {Component} from '@angular/core';
import {ItemModel} from "../shop-model/item-model";
import {ItemService} from "../item-service/item.service";

@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.scss']
})
export class ShopPageComponent {
  items: ItemModel[] = [];

  constructor(private itemService : ItemService) {
  }

  ngOnInit() {
    this.itemService.findAll().subscribe(data => {
      this.items = data;
    });
  }
}
