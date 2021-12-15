import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router,ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';
import { EventDetails } from '../Model/EventDetails';
import { BookEventService } from '../service/bookeventService';
import { SelectedEventService } from '../service/selectedEventService';
import { WeatherService } from '../weather.service';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit, OnDestroy {
  public msg: string;
  public submitted: boolean = false;
  public Email:string;
  subscription: Subscription;
  public eventdetails : EventDetails;
  public forecast : string = "";
  
  constructor(
    private http: HttpClient, 
    private router: Router,
    private route: ActivatedRoute,
    private bookeventservice: BookEventService,
    private selectedEventService : SelectedEventService,
    private weatherService : WeatherService

  ) { 
    this.subscription = selectedEventService.selectedEvent$.subscribe(
       selectedEvent => { this.onEventSelected(selectedEvent) });
  }

  ngOnInit() {}

  onSubmit(myform: NgForm)
  {
    this.submitted = true;
    console.log(this.eventdetails.eventId);
    if (myform.valid)
    {
      this.bookeventservice.bookEvent( this.eventdetails.eventId, 'user' /*this.Email*/,1).subscribe((data: any) => 
        {
          console.log(data);
          this.eventdetails = <EventDetails>data;
        }, (err: any) => {  console.log(err.error.status);
      });

      //this.bookeventservice.bookEvent(this.eventId,this.Email,1);
      this.msg = "You have successfuly booked for the event!!!";  
      this.submitted = false;
      myform.reset();
      
    } 
 
  }

  onEventSelected(selectedEvent:EventDetails) {
    this.eventdetails = selectedEvent;
    this.weatherService.getForecast("m4j%201w5").subscribe((data:any) =>
    {
      console.log(data)
      this.forecast =" ";
      if (data.length>0) {
        if( data[0].precipProb < 10 )
          this.forecast = "Forecast for your event: Sunny Skies Ahead";
        else {
          this.forecast = "Forecast for your event: " + data[0].precipProb + "% chance of Precipitation";
        }
      }

    }, (err: any) => {console.log(err.error.status)
    });
  }

  ngOnDestroy(){
    // prevent memory leak
    this.subscription.unsubscribe();
  }

  }

