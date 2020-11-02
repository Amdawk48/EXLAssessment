export class Employee {
    id: number;
    firstName: string;
    lastName: string;
    jobTitle: string;
    age: number;
    startDate: Date;
    endDate: Date;

    fullName(): string{
        return this.firstName + " " + this.lastName;
    }
    
    public isInFullName(name: string): boolean{
        //console.log("Validating Name");
        if(name == null) 
            return true;
        
        return (this.fullName().includes(name));
      }
    
    public isWithinDate(start: Date, end: Date): boolean{
        if( start == null && end == null )
            return true;
        
        if(start == null)
            return this.endDate < end;

        if(end == null)
            return this.startDate > start;
            
        return this.startDate > start && this.endDate < end;
    }
}


