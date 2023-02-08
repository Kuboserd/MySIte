import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './user-service/user-service.service';
import { UserLoginComponent } from './user-login/user-login.component';
import { HomeComponent } from './home/home.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { WorldsComponent } from './home/worlds/world-list/worlds.component';
import { CharactersComponent } from './home/characters/characters.component';
import { WorldFormComponent } from './home/worlds/world-form/world-form.component';
import { SelectedWorldComponent } from './home/worlds/world-selected/selected-world.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    UserLoginComponent,
    HomeComponent,
    UserRegistrationComponent,
    WorldsComponent,
    CharactersComponent,
    WorldFormComponent,
    SelectedWorldComponent
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
