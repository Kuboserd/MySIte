import { Component } from '@angular/core';
import {Hero} from "./hero";
import {HeroService} from "./hero.service";

@Component({
  selector: 'app-characters',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.scss']
})
export class HeroesComponent {
  heroes: Hero[] = [];

  constructor(private heroService : HeroService) {
  }

  ngOnInit() {
    this.heroService.findAll().subscribe(data => {
      this.heroes = data;
    });
  }
}
