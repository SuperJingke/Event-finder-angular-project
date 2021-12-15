import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SearchEventsComponent } from './search-events/search-events.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { BookEventComponent } from './book-event/book-event.component';
import { SubscriptionFormComponent } from './subscription-form/subscription-form.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { NavbarComponent } from './navbar/navbar.component';
import {GallaryComponent} from './gallary/gallary.component';


const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'home', component:HomeComponent},
  {path:'event-details', component:EventDetailsComponent},

  {path:'aboutus', component:AboutusComponent},
  {path:'gallary', component:GallaryComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
