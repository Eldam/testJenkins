import { Component, OnInit } from '@angular/core';
import { EventService } from '../services/event.service';
import { Event } from '../entities/event';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.scss']
})
export class FilterComponent implements OnInit {

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
  
  private date:Date = null;
  category:string = "all";


  constructor(private eventService: EventService) { }

  ngOnInit() {
    this.categories["Cine"] = "assets/imagenes/Cine.jpg" ;
    this.categories["Series"] = "assets/imagenes/Series.jpg" ;
    this.categories["Literatura"] = "assets/imagenes/Literatura.jpg" ;
    this.categories["Deportes"] = "assets/imagenes/Deportes.jpg" ;
    this.categories["Otros"] = "assets/imagenes/Otros.jpg" ;    
    this.eventService.searchAdvanced(this.date, this.category).subscribe(
      res => {
        
        this.list=res as Event[];
        this.listByPagination();
        
      }
    )
    this.listByPagination();
  }

  searchByDate(event){
    this.date = event.target.value;
    this.eventService.searchAdvanced(this.date,this.category).subscribe(
      res => {
        
        this.list=res as Event[];
        this.listByPagination();
        
      }
    )
    
  }
  searchByCategory(cat:string){
    this.category = cat;
    this.eventService.searchAdvanced(this.date, this.category).subscribe(
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
    this.pageSelected = this.pages.length -1;
    this.listByPagination();
    console.log(this.pageSelected);
  }
  
  showInfo(event:Event){
  	this.eventShow=event;
  }

}
