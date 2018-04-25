import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';


//Angular Modules
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

//Angular Extras
import { AuthGuard } from './auth.guard';
import { routes }  from './app.router';

//Components
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { NavComponent } from './nav/nav.component';

//Services
import { CookieService } from 'ngx-cookie-service';
import { AuthService } from './services/auth.service';
import { EventService } from './services/event.service';


import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BoxEventComponent } from './box-event/box-event.component';
import { CardComponent } from './card/card.component';
import { FilterComponent } from './filter/filter.component';







@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavComponent,
    LoginComponent,
    BoxEventComponent,
    CardComponent,
    FilterComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    routes,
    FormsModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [AuthGuard, AuthService, CookieService, EventService],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]
})

export class AppModule { }
