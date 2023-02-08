import {Component, OnInit} from '@angular/core';
import {World} from "../world"
import {WorldService} from "../world-service/world-service.service";

@Component({
  selector: 'app-worlds',
  templateUrl: './worlds.component.html',
  styleUrls: ['./worlds.component.scss']
})
export class WorldsComponent implements OnInit {
  worlds: World[] = [];

  constructor(private worldService : WorldService) {
  }

  ngOnInit() {
    this.worldService.findAll().subscribe(data => {
      this.worlds = data;
    });
  }
}
