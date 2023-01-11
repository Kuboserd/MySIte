import {Component, OnInit} from '@angular/core';
import {World} from "../worlds/world"
import {WorldServiceService} from "./world-service.service";

@Component({
  selector: 'app-worlds',
  templateUrl: './worlds.component.html',
  styleUrls: ['./worlds.component.scss']
})
export class WorldsComponent implements OnInit {
  worlds: World[] = [];

  constructor(private worldService : WorldServiceService) {
  }

  ngOnInit() {
    this.worldService.findAll().subscribe(data => {
      this.worlds = data;
    });
  }
}
