import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class GetAllAppsService {

  data:any [] ;

  constructor(private http: HttpClient) {}
   
      baseUrl: string = 'http://localhost:8080/graph/apps';
  
    
    
     async getApps(): Promise<any[]> {
    
   //  console.log(fakeUsers);
 //  return Observable.of(fakeUsers).delay(2);
   return await this.http.get(this.baseUrl).toPromise().then(response => response as any[]) ;
   // console.log(response.json());

 
  } 
 

   
}
