import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { EventDetails } from '../Model/EventDetails';
import { BookEventService } from '../service/bookeventservice';
import { SelectedEventService } from '../service/selectedEventService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

//  @Output() eventDetails =new EventEmitter<EventDetails>();
//@Output() eventID  = new EventEmitter<number>();

  public sampleEvent : EventDetails;

   events: EventDetails[] = new Array<EventDetails>(); 

  constructor(private router:Router, private selectedEventService: SelectedEventService,
    private bookEventService: BookEventService) { }

  ngOnInit() {
    
  /*  this.bookEventService.SearchUnbookedEvents('k.t@test.com').subscribe((data: any) => 
        {
          console.log(data);
          this.events = <EventDetails[]>data;
        }, (err: any) => {  console.log(err.error.status);
      });*/


      this.bookEventService.bookEvent(1,'k.t@test.com',1).subscribe((data: any) => 
        {
          console.log(data);
          this.events.push(data);
          this.events.push(data);
        }, (err: any) => {  console.log(err.error.status);
      });

  }
  
  onEventDetails()
  {
  //    this.eventDetails.emit(this.sampleEvent);
  //  this.eventID.emit(11);
  this.sampleEvent = this.events[0];
    console.log(this.sampleEvent);
    this.router.navigate(['/event-details']).then(() => {
      this.selectedEventService.selectEvent(this.sampleEvent);
    });
  }
}
