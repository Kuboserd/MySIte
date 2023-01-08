import { Component } from '@angular/core';
import {User} from "../user-model/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../user-service/user-service.service";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {

  user: User;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
    this.user = new User();
  }

  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  // TODO: dodac strone glowna uzytkownika
  gotoUserList() {
    this.router.navigate(['/panel']);
  }

  role = ['ROLE_USER', 'ROLE_ADMIN']
}
