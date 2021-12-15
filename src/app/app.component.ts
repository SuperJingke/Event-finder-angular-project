import { Component } from '@angular/core';
import { EventDetails } from './Model/EventDetails';
import { SelectedEventService } from './service/selectedEventService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Events-all-around';
  public dummyEvent : EventDetails = new EventDetails(0, "Your next event", "brief", "", "","","","","");

  constructor(private selectedEventService: SelectedEventService) {
    this.selectedEventService.selectEvent(this.dummyEvent);
   }


}
