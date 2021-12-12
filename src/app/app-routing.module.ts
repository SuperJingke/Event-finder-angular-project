import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SearchEventsComponent } from './search-events/search-events.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { BookEventComponent } from './book-event/book-event.component';
import { SubscriptionFormComponent } from './subscription-form/subscription-form.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { NavbarComponent } from './navbar/navbar.component';


const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'home', component:HomeComponent},
  {path:'event-details', component:EventDetailsComponent},
// To do : add path for search map 
  {path:'aboutus', component:AboutusComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
