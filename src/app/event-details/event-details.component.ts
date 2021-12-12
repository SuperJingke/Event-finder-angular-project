import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { from } from 'rxjs';
import { EventDetails } from '../Model/EventDetails';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  public msg: string;
  public submitted: boolean = false;

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
    //private productService: ProductService
  ) { }

  ngOnInit() {
  }
  onSubmit(myform: NgForm)
  {
    this.submitted = true;
    if (myform.valid)
    {
      this.msg="Event booking done successfully!!";
      this.submitted = false;
      myform.reset();
    }

  }
}
