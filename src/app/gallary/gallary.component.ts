import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { EventDetails } from '../Model/EventDetails';
import { BookEventService } from '../service/bookeventService';
import { SelectedEventService } from '../service/selectedEventService';


@Component({
  selector: 'app-gallary',
  templateUrl: './gallary.component.html',
  styleUrls: ['./gallary.component.css']
})
export class GallaryComponent implements OnInit {

  public selectedEvent : EventDetails;
  public myEvents: EventDetails[] = []
  public searchEvents: EventDetails[] = []; 

  constructor(private router:Router, private selectedEventService: SelectedEventService,
  private bookEventService: BookEventService) { }
  ngOnInit() {
    this.bookEventService.SearchUnbookedEvents('user', "*").subscribe((data: any) => 
    {
      console.log(data);
      this.searchEvents = <EventDetails[]>data;
    }, (err: any) => {  console.log(err.error.status);this.searchEvents=[]
  });

this.bookEventService.getBookedEvents('user').subscribe((data: any) => 
  {
    console.log(data);
    this.myEvents = <EventDetails[]>data;
  }, (err: any) => {  console.log(err.error.status);this.searchEvents=[]
});

}





}