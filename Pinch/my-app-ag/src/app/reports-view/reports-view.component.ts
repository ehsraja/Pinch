import { Component, OnInit, ViewChild  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { AgGridNg2 } from 'ag-grid-angular';
import {ColDef, ColumnApi, GridApi} from 'ag-grid-community';



@Component({
  selector: 'app-reports-view',
  templateUrl: './reports-view.component.html',
  styleUrls: ['./reports-view.component.scss']
})
export class ReportsViewComponent  implements OnInit {
	 @ViewChild('agGrid') agGrid: AgGridNg2;

 /* columnDefs = [
        {headerName: "ID", "field": "ID" },
        {"headerName": "TimeIN", "field": "TimeIN" },
        {"headerName": "TimeOut", "field": "TimeOut"}
    ]; */
	
	 private api: GridApi;
    private columnApi: ColumnApi;
     
 constructor(private http: HttpClient, private activeRoute: ActivatedRoute) {
	 
	

    }
	

	
    columnDefs: any; 
     rowData: any;
	  name: ""; 
	  row =  {"Num of trades":10,"TimeIN":"15:34:11","reportName":"Sample","timetoCompute":1000,"Timeout":"15:34:12","Ticker":"TURKkkEY"};
	

     ngOnInit() {
		 this.activeRoute.params.subscribe(routeParams => {
		this.name = routeParams.name ;
		console.log("param name : " + this.name);
		});
		//  const name = this.activeRoute.snapshot.paramMap.get('name');
		 // console.log("param name" + name);
		  this.http.get('http://localhost:8080/reports/header/Sample').
		 subscribe(data => { console.log(data); 
                     		this.columnDefs = data });
         this.http.get('http://localhost:8080/reports/content/Sample').
	    subscribe(data =>  {this.rowData = data});
	    console.log("adding row");
	
 
		
	 }
	 
	 onGridReady(params): void {
        this.api = params.api;
        this.columnApi = params.columnApi;
        this.api.sizeColumnsToFit();
		 this.agGrid.api.updateRowData({add: [this.row]});
	//	 this.api.updateRowData({add: [this.row]] })
    }

}
