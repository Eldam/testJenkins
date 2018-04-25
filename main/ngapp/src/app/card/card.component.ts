import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { EventService} from '../services/event.service';
import { Event } from '../entities/event';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  
  @Input() event:Event; 
  @Output() showEvent = new EventEmitter<any>();
  description:string;

  categories: { [category: string] : string; } = {};

  constructor() { }

  ngOnInit() {
    this.categories["Cine"] = "assets/imagenes/Cine.jpg" ;
    this.categories["Series"] = "assets/imagenes/Series.jpg" ;
    this.categories["Literatura"] = "assets/imagenes/Literatura.jpg" ;
    this.categories["Deportes"] = "assets/imagenes/Deportes.jpg" ;
    this.categories["Otros"] = "assets/imagenes/Otros.jpg" ;  
    this.description = (this.event.description.length < 50) ? this.event.description : this.event.description.substr(0,50) + "...";
  }

  showDetail(){
  	this.showEvent.emit(this.event);
  }


}
