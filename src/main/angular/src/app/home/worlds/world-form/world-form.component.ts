import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {World} from "../world";
import {WorldService} from "../world-service.service";

@Component({
  selector: 'app-world-form',
  templateUrl: './world-form.component.html',
  styleUrls: ['./world-form.component.scss']
})
export class WorldFormComponent {

  world: World;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private worldService: WorldService) {
    this.world = new World();
  }

  onSubmit() {
    this.worldService.save(this.world).subscribe(result => this.gotoWorldList());
  }

  gotoWorldList() {
    this.router.navigate(['/worlds']);
  }

}
