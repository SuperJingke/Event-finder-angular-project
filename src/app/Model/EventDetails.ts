
export class EventDetails {

    constructor(

    public eventId: number,
    public isBooked:boolean =false,
    public bookings:any,
    public fullName: string,  
    public brief: string, 
    public contact: string, 
    public imageUrl: string, 
    public location: string,
    public postalCode: string,
    public dateStart: string, 
    public dateEnd: string, 
    public fullDescription :string,
    
    
    )	
    {
    
    }
    
    }
    