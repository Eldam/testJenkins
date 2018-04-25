import { ModuleWithProviders } from '@angular/core';
import { Routes , RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';

import { AuthGuard } from './auth.guard';
import { BoxEventComponent } from './box-event/box-event.component';
import { FilterComponent } from './filter/filter.component';

export const router: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'index', component: MainComponent,
        children : [
            {  path: '', component: BoxEventComponent, pathMatch: 'full' },
            {  path:'filter', component: FilterComponent }
        ]
    },
    { path: '', redirectTo: '/index', pathMatch: 'full'}
    
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
