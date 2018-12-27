import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ReportListService} from "./report.service";


@Component({
  selector: 'app-reports-list',
  templateUrl: './reports-list.component.html',
  styleUrls: ['./reports-list.component.scss']
})
export class ReportsListComponent implements OnInit {
	
	//reports = [{name:"RCS-Ticker-Calculation"},{name:"RCS-Trade-Calculation"}];
	
	reports:any = [];

  constructor(private router: Router,private reportListService: ReportListService) { }
  
  getReports() {
    this.reports = [];
    this.reportListService.getReports().subscribe((data: {}) => {
      console.log(" Hi " + data);
      this.reports = data;
    });
  }
  
  onSelect(report): void {
	  console.log("Hi" + report.name )
	    this.router.navigate(['reports',report]);
  }

  ngOnInit() {
	  this.getReports(); 
  }

}
