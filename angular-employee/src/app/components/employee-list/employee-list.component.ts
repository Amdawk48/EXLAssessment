import { templateJitUrl } from '@angular/compiler';
import { Component, OnInit, Pipe } from '@angular/core';
import { Observable, from, fromEventPattern} from 'rxjs';
import { Employee } from '../../common/employee';
import { EmployeeService } from '../../services/employee-service.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {

  employees: Employee[];
  empCount: number;
  nameSearch: string;
  startDateSearch: Date;
  endDateSearch: Date;
  constructor(private employeeService: EmployeeService) { 
  }

  ngOnInit(): void {
    //this.getFullList();
  }

  getFullList(){
    this.employeeService.findAll().subscribe(data => {
      this.employees = data;
      this.empCount = this.employees.length;
    });
  }

  validEmployee(employee: Employee): boolean{
    
    let res: boolean = true;
     
              //&& employee.isWithinDate(this.startDateSearch, this.endDateSearch);
    return employee.isWithinDate(this.startDateSearch, this.endDateSearch);
  }

  getEmployeesByCriteria(){
    
    
    console.log();
    //this.employees = null;
    let tempArr: Employee[];
    if((!this.nameSearch || 0 === this.nameSearch.length) && this.startDateSearch == null && this.endDateSearch == null){
      this.getFullList();
    } else { 
      let n: string = this.nameSearch == null ? "":this.nameSearch.toLowerCase();
      let start: Date = this.startDateSearch;
      let end: Date = this.endDateSearch;
      let validName, validDates: boolean;
      console.log(`Name: ${this.nameSearch}`);
      //console.log(`After ${this.startDateSearch}`);
      //console.log(`Before ${this.endDateSearch}`);
      this.employeeService.findAll().subscribe(data => {
        this.employees = data;
        this.employees = data.filter(
          function (e) {
            validName =  e.firstName.toLowerCase().includes(n) || e.lastName.toLowerCase().includes(n);

            if(start == null && end == null){
              validDates = true;
              return validName;
            } 

            if(start != null){
              validDates = e.startDate >= start;   
            }
            if (end != null){
              validDates = e.endDate <= end;
            }
            return validName && validDates;
          }
            
        )
        
        this.empCount = this.employees.length;
      });
      
    }
  }

}
