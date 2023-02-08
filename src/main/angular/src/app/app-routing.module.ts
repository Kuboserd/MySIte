import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {UserLoginComponent} from "./user-login/user-login.component";
import {HomeComponent} from "./home/home.component";
import {UserRegistrationComponent} from "./user-registration/user-registration.component";
import {WorldsComponent} from "./home/worlds/world-list/worlds.component";
import {WorldFormComponent} from "./home/worlds/world-form/world-form.component";

const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'adduser', component: UserFormComponent},
  {path: 'login', component: UserLoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'worlds', component: WorldsComponent},
  {path: 'addworld', component: WorldFormComponent},
  {path: 'registration', component: UserRegistrationComponent},
  {path: '**', redirectTo: ''}
];
export const routing = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
