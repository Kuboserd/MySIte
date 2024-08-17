import {Component} from '@angular/core';
import {User} from "../user-model/user";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginServiceService} from "./login-service/login-service.service";


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
    private loginService: LoginServiceService) {
    this.user = new User();
  }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }

  onSubmit() {
    (this.loginService.login(this.user)).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem(
          'token',
          window.btoa(this.user.login + ':' + this.user.password)
        );
        this.router.navigate(['/home']);
      } else {
        alert("Authentication failed.")
      }
    });
  }

}
