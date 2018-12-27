import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class ReportListService {

  constructor(private http: HttpClient) { }
  
  baseUrl: string = 'http://localhost:8080/reports/list';
  
  getReports() {
    
   //  console.log(fakeUsers);
 //  return Observable.of(fakeUsers).delay(2);
   return this.http.get(this.baseUrl);
  }
}
