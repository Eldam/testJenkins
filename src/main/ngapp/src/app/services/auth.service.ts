import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

  login(login,pass){
    return this.http.get('/LETTA/login?login=' + login + "&password=" + pass);
  }

  logout(){
    return this.http.get('/LETTA/logout');
  }

}
