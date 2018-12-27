import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class GetAppsService {

  constructor(private http: HttpClient) {}
   
      baseUrl: string = 'http://localhost:8080/graph/apps';
  
  getApps() {
    
   //  console.log(fakeUsers);
 //  return Observable.of(fakeUsers).delay(2);
   return this.http.get(this.baseUrl);
  } 
 

   
}
