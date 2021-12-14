import { Injectable } from '@angular/core';
import { EventDetails } from '../Model/EventDetails'
import { Subject } from'rxjs';

@Injectable({
    providedIn:'root'
})
export class SelectedEventService {

    private selectedEventSource = new Subject<EventDetails>();

    selectedEvent$ = this.selectedEventSource.asObservable();

    selectEvent(event:EventDetails) {
        this.selectedEventSource.next(event);
    }
}

