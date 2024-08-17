import {Component} from '@angular/core';
import {User} from "../user-model/user";
import {ActivatedRoute, Router} from "@angular/router";
import {RegistrationServiceService} from "./registration-service/registration-service.service";

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent {

  user: User;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private registrationService: RegistrationServiceService) {
    this.user = new User();
  }

  onSubmit() {
    this.registrationService.register(this.user).subscribe(result => this.gotoHome());
  }

  gotoHome() {
    this.router.navigate(['home']);
  }

}
