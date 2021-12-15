
 import { Injectable } from '@angular/core';
 import { HttpClient } from '@angular/common/http';
 import { EventDetails } from '../Model/EventDetails';
 import { BehaviorSubject, Observable } from 'rxjs';
 import { environment } from 'src/environments/environment';
 
 
 @Injectable({ 
      providedIn: 'root'
 })
 export class BookEventService 
 {
    products : Observable<EventDetails[]>;
    private _events:BehaviorSubject<EventDetails[]>;
    private baseUrl: string;
    private index: number =3;
    private datastore:{
      prods: EventDetails[]
    };

 constructor(private httpClient: HttpClient) {
    this.baseUrl =  environment.baseUrl;  
    this.datastore = { prods: []};
    this._events = <BehaviorSubject<EventDetails[]>>new BehaviorSubject([]);
    this.products = this._events.asObservable();
   }

 public bookEvent(eventid: number,email: string,count: number) 
  {
    console.log('calling bookEvent');
    
    //return this.httpClient.get(`${this.baseUrl}event/book/${eventid}/${email}/${count}`);
    return this.httpClient.get(`${this.baseUrl}event/book/1/k.t@test.com/1`);
  }

  public SearchUnbookedEvents(email: string)
  {
    console.log('calling UnbookedEvents');
    //return this.httpClient.get(`${this.baseUrl}unBookedEvents/k.t@test.com/*`);
    return this.httpClient.get(`${this.baseUrl}event/book/1/k.t@test.com/1`);

  }
}