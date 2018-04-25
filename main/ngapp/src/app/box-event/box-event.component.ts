import { Component, OnInit, Input, Host, SimpleChanges } from '@angular/core';
import { EventService } from '../services/event.service';
import { Event } from '../entities/event';


@Component({
  selector: 'app-box-event',
  templateUrl: './box-event.component.html',
  styleUrls: ['./box-event.component.scss']
})
export class BoxEventComponent implements OnInit {

  private _wordSearch: string;

  eventShow: Event = {
    id:0,
    name:"",
    description:"",
    date:null,
    time:null,
    category:"",
    location:"",
    maxInscriptions:0
  };
  categories: { [category: string] : string; } = {};
  list: Event[] = [];
  pages: number[] = [];
  pageSelected: number = 0;
  listShow: Event[] = [];

  constructor(private eventService: EventService) { }

  ngOnInit() {
    this.categories["Cine"] = "assets/imagenes/Cine.jpg" ;
    this.categories["Series"] = "assets/imagenes/Series.jpg" ;
    this.categories["Literatura"] = "assets/imagenes/Literatura.jpg" ;
    this.categories["Deportes"] = "assets/imagenes/Deportes.jpg" ;
    this.categories["Otros"] = "assets/imagenes/Otros.jpg" ;    
    this.eventService.currentMessage.subscribe(message => {
      this._wordSearch = message;
      this.search(this._wordSearch);
    })
    this.listByPagination();
  }

  search(word){
    this.eventService.search(word).subscribe(
      res => {
        
        this.list=res as Event[];
        this.listByPagination();
        
      }
    )
    
  }

  listByPagination(){
    this.pages = Array(Math.ceil(this.list.length/18));
    this.listShow = this.list.slice(this.pageSelected*18,(this.pageSelected+1)*18);
    console.log(this.listShow);
  }

  selectPage(index){
    this.pageSelected = index;
    this.listByPagination();
    console.log(this.pageSelected);
  }

  selectFirstPage(){
    this.pageSelected = 0;
    this.listByPagination();
    console.log(this.pageSelected);
  }

  selectLastPage(){
    this.pageSelected = this.pages.length - 1;
    this.listByPagination();
    console.log(this.pageSelected);
  }
  
  showInfo(event:Event){
  	this.eventShow=event;
  }
}
