import { Component, OnInit } from '@angular/core';

import { AuthService } from '../services/auth.service';
import { Router }  from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model = {
    login: "",
    pass: ""
  }
  alert:boolean = false;
  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit() {
    
  }

  ngSubmit(){
    //
    this.auth.login(this.model.login,this.model.pass)
      .subscribe(
        res => {
          this.alert=false;
          this.router.navigate(['/index']);    
        },
        err => {
          this.alert = true;
        }
      );
  }

}
