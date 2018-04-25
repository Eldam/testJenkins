import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Event } from '../entities/event';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class EventService {

  private messageSource = new BehaviorSubject("");
  currentMessage = this.messageSource.asObservable();

  constructor(private http: HttpClient) { }

  search(word){
    return this.http.get('/LETTA/rest/events?search='+word);
  }

  searchAdvanced(date:Date,category:String){
    
    if(date == null){
      return this.http
      .get('/LETTA/rest/events?category='+category+'&date=none&order=none');
    }else{
      return this.http
      .get('/LETTA/rest/events?category='+category+'&date='+date+'&order=none');
    }
  }

  changeMessage(message: string) {
    this.messageSource.next(message)
  }


  

  
}
