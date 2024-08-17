import {Component, OnInit} from '@angular/core';
import {World} from "../world-model/world"
import {WorldService} from "../world-service/world-service.service";

@Component({
  selector: 'app-worlds',
  templateUrl: './world-list.component.html',
  styleUrls: ['./world-list.component.scss']
})
export class WorldList implements OnInit {
  worlds: World[] = [];

  constructor(private worldService : WorldService) {
  }

  ngOnInit() {
    this.worldService.findAll().subscribe(data => {
      this.worlds = data;
    });
  }
}
