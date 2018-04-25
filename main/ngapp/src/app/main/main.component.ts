import { Component, OnInit, OnChanges, Input,Output, EventEmitter, ViewChild } from '@angular/core';

import { NavComponent } from '../nav/nav.component';
import { BoxEventComponent } from '../box-event/box-event.component';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
