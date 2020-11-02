import { Injectable, Pipe, PipeTransform } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Employee } from '../common/employee';
import { Observable } from 'rxjs';
import { catchError, filter, map, tap } from 'rxjs/operators'
 
@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  private employeeUrl: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { 
    this.employeeUrl = "http://localhost:8080/employees";
  }

  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl)
      .pipe(
        catchError(this.employeeError<Employee[]>('findAll', []))
      );
  }

  findByCriteria(name: string, start: Date, end: Date): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.employeeUrl)
      .pipe(
        
        catchError(this.employeeError<Employee[]>('findAll', []))
      )
  }

  public addEmployee(employee: Employee){
    return this.http.post<Employee>(this.employeeUrl, employee, this.httpOptions)
      .pipe(
        catchError(this.employeeError<Employee>('addEmployee'))
      );
  }

  private employeeError<T>(operation = 'opertation', result?: T){
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      
      return;
    };
    
  }
}