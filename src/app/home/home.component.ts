import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { EventDetails } from '../Model/EventDetails';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  @Output() eventDetails =new EventEmitter<EventDetails>();
@Output() eventID  = new EventEmitter<number>();

  public sampleEvent : EventDetails = 
  {
    eventId:null, 
    FullName:null,
    Email:null,
    IntrestedIn:null,
    Message:null
    
   };

  constructor(private router:Router) { }

  ngOnInit() {
    this.sampleEvent = new EventDetails(1,'St. Jacobs Sparkles','k.t@test.com',
    'Our annual St. Jacobs Sparkles event will occur again this fall. We’ve stretched out the dates to avoid crowding, so you get even more time to engage in the various activities and do your holiday shopping! Thousands of sparkling lights, a visit from Santa, sales & promotions, and more!' ,'test');

  }
  
  onEventDetails()
  {

    this.eventDetails.emit(this.sampleEvent);
    this.eventID.emit(11);
    console.log(this.eventID);
     this.router.navigate(['/event-details']);
  }
}
