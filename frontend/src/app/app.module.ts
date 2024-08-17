import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {UserService} from './user-service/user-service.service';
import {UserLoginComponent} from './user-login/user-login.component';
import {HomeComponent} from './home/home.component';
import {UserRegistrationComponent} from './user-registration/user-registration.component';
import {WorldList} from './home/worlds/world-list/world-list.component';
import {HeroListComponent} from './home/heroes/hero-list/hero-list.component';
import {WorldFormComponent} from './home/worlds/world-form/world-form.component';
import {WorldSelectedComponent} from './home/worlds/world-selected/world-selected.component';
import {ShopPageComponent} from './home/shops/shop-page/shop-page.component';
import {ShopListComponent} from './home/shops/shop-list/shop-list.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    UserLoginComponent,
    HomeComponent,
    UserRegistrationComponent,
    WorldList,
    HeroListComponent,
    WorldFormComponent,
    WorldSelectedComponent,
    ShopPageComponent,
    ShopListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
