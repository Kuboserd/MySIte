import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {UserLoginComponent} from "./user-login/user-login.component";
import {HomeComponent} from "./home/home.component";
import {UserRegistrationComponent} from "./user-registration/user-registration.component";
import {WorldList} from "./home/worlds/world-list/world-list.component";
import {WorldFormComponent} from "./home/worlds/world-form/world-form.component";
import {HeroListComponent} from "./home/heroes/hero-list/hero-list.component";
import {ShopPageComponent} from "./home/shops/shop-page/shop-page.component";
import {ShopListComponent} from "./home/shops/shop-list/shop-list.component";

const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'adduser', component: UserFormComponent},
  {path: 'login', component: UserLoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'worlds', component: WorldList},
  {path: 'addworld', component: WorldFormComponent},
  {path: 'registration', component: UserRegistrationComponent},
  {path: 'heroes', component: HeroListComponent},
  {path: 'shops', component: ShopListComponent},
  {path: 'shop-page', component: ShopPageComponent},
  {path: '**', redirectTo: ''}
];
export const routing = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
