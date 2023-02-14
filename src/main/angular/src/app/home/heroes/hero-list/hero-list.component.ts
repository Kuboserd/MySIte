import { Component } from '@angular/core';
import {Hero} from "../hero-model/hero";
import {HeroService} from "../hero-service/hero.service";

@Component({
  selector: 'app-characters',
  templateUrl: './hero-list.component.html',
  styleUrls: ['./hero-list.component.scss']
})
export class HeroListComponent {
  heroes: Hero[] = [];

  constructor(private heroService : HeroService) {
  }

  ngOnInit() {
    this.heroService.findAll().subscribe(data => {
      this.heroes = data;
    });
  }
}
