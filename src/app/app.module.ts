import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SearchEventsComponent } from './search-events/search-events.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { BookEventComponent } from './book-event/book-event.component';
import { SubscriptionFormComponent } from './subscription-form/subscription-form.component';
import { AboutusComponent } from './aboutus/aboutus.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchEventsComponent,
    EventDetailsComponent,
    BookEventComponent,
    SubscriptionFormComponent,
    AboutusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
