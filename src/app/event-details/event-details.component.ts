import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router,ParamMap } from '@angular/router';
import { from } from 'rxjs';
import { EventDetails } from '../Model/EventDetails';
import { BookEventService } from '../service/bookeventService';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  public msg: string;
  public submitted: boolean = false;
public eventId:number;
public Email:string;


  public eventdetails : EventDetails = 
  {
    eventId:null, 
    FullName:null,
    Email:null,
    IntrestedIn:null,
    Message:null
    
   };
  constructor(
    private http: HttpClient, 
    private router: Router,
    private route: ActivatedRoute,
    private bookeventservice: BookEventService
  ) { }

  ngOnInit() {}
   //private _eventID = 0;


  @Input() eventID: number;
/*@Input() set eventID(eventID: number){
  this._eventID = eventID;
}*/

  onSubmit(myform: NgForm)
  {
    this.submitted = true;
    console.log(this.eventID);
    if (myform.valid)
    {
      this.bookeventservice.bookEvent( this.eventID,this.Email,1).subscribe((data: any) => 
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

  }

