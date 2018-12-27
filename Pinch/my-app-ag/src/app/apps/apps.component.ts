import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {GetAppsService} from "./get-apps.service";

@Component({
  selector: 'app-apps',
  templateUrl: './apps.component.html',
  styleUrls: ['./apps.component.scss']
})
export class AppsComponent implements OnInit {
	
	apps:any = [];

  constructor( private getAppsService: GetAppsService) { }

  ngOnInit() {
	  this.getApps()
  }
  
   getApps() {
    this.apps = [];
    this.getAppsService.getApps().subscribe((data: {}) => {
      console.log(" Hi " + data);
      this.apps = data;
    });
  }

}
