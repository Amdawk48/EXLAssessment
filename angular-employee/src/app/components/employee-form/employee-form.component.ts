import { HttpHeaders } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/common/employee';
import { EmployeeService } from 'src/app/services/employee-service.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})

export class EmployeeFormComponent {

  employee: Employee;
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService) {
    this.employee = new Employee(); 
  }

  onSubmit() {
    this.employeeService.addEmployee(this.employee)
      .subscribe( employee =>
        this.goToEmployeeList()
      );
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }

}
