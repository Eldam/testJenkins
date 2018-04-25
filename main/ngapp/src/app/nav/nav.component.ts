import { Component, OnInit, Output, EventEmitter, Host } from '@angular/core';
import { EventService } from '../services/event.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  word="";
  
  constructor(private eventService: EventService, private route:Router) { }

  ngOnInit() {
    
  }

  takeWord(event){
    this.word = event.target.value;
    this.eventService.changeMessage(this.word);
  }

  goSearch(event){
    this.route.navigate(['/index']); 
  }
  

}
