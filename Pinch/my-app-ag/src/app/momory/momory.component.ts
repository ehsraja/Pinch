import { Component, OnInit,ViewEncapsulation,ViewChildren,ViewChild,ElementRef,QueryList,AfterViewInit ,OnChanges } from '@angular/core';
import {GetAllAppsService} from "./getall-apps.service";
import { HttpClient } from '@angular/common/http';
import * as d3 from 'd3';
import * as scale from 'd3-scale';


@Component({
  selector: 'app-momory',
  templateUrl: './momory.component.html',
  styleUrls: ['./momory.component.scss']
})
export class MomoryComponent implements OnInit   {

  
	
	// data:any = [];
    @ViewChildren('divs') 
    divs: QueryList<ElementRef> ;

    apps:any = [];
	//  @ViewChildren('appchart') apcharts: QueryList<ElementRef>
 
  //    parseDate = d3.timeParse('%Y-%m-%d %H:%M:%S'); 

  constructor(private getAllAppsService: GetAllAppsService, private http: HttpClient ) { }

  ngOnInit() {
	  this.apps =  this.getApps();
	//  console.log("sds" + this.divs.length);
	  
	/*  this.apps.forEach(app => {
	  this.http.get('http://localhost:8080/graph/memoryGraph/'+ app).
		 subscribe(dat => { console.log(dat); 
                         this.data =  dat ;
                       
               });
	   
  });*/

  

  }


  
 getApps() {
    this.apps = [];
    this.getAllAppsService.getApps().subscribe((data: {}) => {
      console.log(" Hi " + data);
      this.apps = data;
      console.log("sds" + this.divs.length);
     
    });
  } 



 /* buildChart(memoryData) {
	   console.log("drawing chart");
     this.formatDate();
	
	 var margin = {top: 20, right: 20, bottom: 30, left: 50};
    var width = 600 - margin.left - margin.right;
    var height = 250 - margin.top - margin.bottom;
   // var parseDate = d3.time.format("%Y-%m-%d %H:%M:%S").parse;

 
   
    var x = d3.scaleTime()
        .range([0, width]);

    var y = d3.scaleLinear()
        .range([height, 0]);

    var xAxis = d3.axisBottom(x).ticks(5);
       
    var yAxis = d3.axisLeft(y).ticks(5);
	
	 let _this = this;
       
   console.log("Enter here")
    var line = d3.line()
        .x(function(d) {        
   console.log("Enter here2" + d.timeCatureed.getTime()) 
		 if (d.timeCatureed instanceof Date) {
        console.log('time market' + d.timeCatureed.getTime());
		return x(d.timeCatureed.getTime())
     }
   })
    .y(function(d) { 
      console.log('Close market' + d.freeMemory );
      return y(d.freeMemory); });

     var line2 = d3.line()
        .x(function(d) {        
   console.log("Enter here2" + d.timeCatureed.getTime()) 
		 if (d.timeCatureed instanceof Date) {
        console.log('time market' + d.timeCatureed.getTime());
		return x(d.timeCatureed.getTime())
     }
   })
     .y(function(d) { 
      console.log('Close market' + d.totalmemory );
      return y(d.totalmemory); });


    var svg = d3.select(this.chartElement.nativeElement)
	 .append('svg')
     .attr('width', width + margin.left + margin.right)
     .attr('height', height + margin.top + margin.bottom)
     .attr("stroke", "white")
     .append('g')
     .attr('transform', `translate(${margin.left},${margin.top})`);
  

 

    x.domain(d3.extent(this.data, function(d) { 
	 if (d.timeCatureed instanceof Date)
	   return (d.timeCatureed as Date).getTime(); }));
    y.domain([0, d3.max(this.data, function(d) { return Math.max(d.totalmemory, d.freeMemory);})]);
	
	
	 svg.append('path')
     .attr('class', 'line')
     .style('stroke', 'green')
     .style('fill', 'none')
     .attr('d', line(this.data)); 
	
 
   
   svg.append("g")
          .attr("class", "x axis")
          .style("stroke", "white")
          .attr("transform", "translate(0," + height + ")")
          .call(xAxis)
	

   svg.append("g")
          .attr("class", "y axis")
           .style("stroke", "white")
          //  .style("fill", "white")
          .call(yAxis)

   svg.append("path")
         .datum(this.data)
          .attr("class", "line")
		  .style('stroke', 'red')
		  .style('fill', 'none')
          .attr("d", line); 

          svg.append("path")
         .datum(this.data)
          .attr("class", "line")
		  .style('stroke', 'green')
		  .style('fill', 'none')
          .attr("d", line2); 

	
  } */


}
