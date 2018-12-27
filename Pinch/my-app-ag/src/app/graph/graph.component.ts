import { Component, OnInit ,ViewEncapsulation,ViewChild ,ElementRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import {ChangeDetectionStrategy, Component, ElementRef, Input, OnChanges, ViewChild,OnInit,ViewEncapsulation} from '@angular/core';

import * as d3 from 'd3';
import * as scale from 'd3-scale';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss'],
   encapsulation: ViewEncapsulation.None
})
export class GraphComponent implements OnInit { //,OnChanges {
   @ViewChild('chart')
     chartElement: ElementRef;

      @ViewChild('chart2')
     chartElement2: ElementRef;

     private dimensions: Array<string>;
	 
        data:any = [];
        cpuData:any = [];
	 
	  /* data = [{
            "creat_time": "2013-03-12 15:09:04",
            "record_status": "ok",
            "roundTripTime": 16
        }, {
            "creat_time": "2013-03-12 14:59:06",
            "record_status": "ok",
            "roundTripTime": 0
        }, {
            "creat_time": "2013-03-12 14:49:04",
            "record_status": "ok",
            "roundTripTime": 297
        }, {
            "creat_time": "2013-03-12 14:39:06",
            "record_status": "ok",
            "roundTripTime": 31
        },{
            "creat_time": "2013-03-12 14:29:03",
            "record_status": "ok",
            "roundTripTime": 0
    }]; */
   parseDate = d3.timeParse('%Y-%m-%d %H:%M:%S');

  constructor(private http: HttpClient) { }

  ngOnInit() {
	    this.http.get('http://localhost:8080/graph/memoryGraph/ABC').
		 subscribe(dat => { console.log(dat); 
                         this.data =  dat ;
                        this.buildChart();
               });

      this.http.get('http://localhost:8080/graph/CPUGraph/ABC').
		 subscribe(dat => { console.log(dat); 
                         this.cpuData =  dat ;
                      this.buildChart2(); });                 
	  
	   
  }

  buildChart2() {
	   console.log("drawing chart2");
     this.formatDate2();
	
	 var margin = {top: 20, right: 20, bottom: 30, left: 50};
    var width = 600 - margin.left - margin.right;
    var height = 250 - margin.top - margin.bottom;
  

 
   
    var x = d3.scaleTime()
        .range([0, width]);

    var y = d3.scaleLinear()
        .range([height, 0]);

    var xAxis = d3.axisBottom(x).ticks(5);
       
    var yAxis = d3.axisLeft(y).ticks(5);
	
	 let _this = this;
       
   console.log("Enter here")
   

     var line2 = d3.line()
        .x(function(d) {        
   console.log("Enter here2" + d.timeCatureed.getTime()) 
		 if (d.timeCatureed instanceof Date) {
        console.log('time market' + d.timeCatureed.getTime());
		return x(d.timeCatureed.getTime())
     }
   })
     .y(function(d) { 
      console.log('Close market' + d.systemCpu );
      return y(d.systemCpu); }); 


    var svg = d3.select(this.chartElement2.nativeElement)
	 .append('svg')
     .attr('width', width + margin.left + margin.right)
     .attr('height', height + margin.top + margin.bottom)
     .attr("stroke", "white")
     .append('g')
     .attr('transform', `translate(${margin.left},${margin.top})`);
   

    x.domain(d3.extent(this.cpuData, function(d) { 
	 if (d.timeCatureed instanceof Date) 
	   return (d.timeCatureed as Date).getTime(); }));
    y.domain([0, d3.max(this.cpuData, function(d) { return Math.max(d.systemCpu, d.appCPU);})]);

     var line = d3.line()
        .x(function(d) {        
   console.log("Enter here2" + d.timeCatureed.getTime()) 
		 if (d.timeCatureed instanceof Date) {
        console.log('time market' + d.timeCatureed.getTime());
		return x(d.timeCatureed.getTime())
     }
   })
    .y(function(d) { 
      console.log('Close market' + d.appCPU );
      return y(d.appCPU); });
	  
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
         .datum(this.cpuData)
          .attr("class", "line")
		  .style('stroke', 'red')
		  .style('fill', 'none')
          .attr("d", line); 

          svg.append("path")
         .datum(this.cpuData)
          .attr("class", "line")
		  .style('stroke', 'green')
		  .style('fill', 'none')
          .attr("d", line2);  

	
  }
  
  buildChart() {
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
	
 
   /*  svg.append('g')
     .attr('class', 'x axis')
     .attr('transform', `translate(0,${height})`)
     .call(xAxis);

    // Add the Y Axis
    svg.append('g')
     .attr('class', 'y axis')
     .call(yAxis)
	 .append('text')
	 .attr('transform', 'rotate(-90)')
      .attr('y', 6)
      .attr('dy', ".71em")
      .style('text-anchor', 'end')
	  .text('return time(ms)'); */


/*svg.append("text")      // text label for the x axis
        .attr("x", width+10 )
        .attr("y",  200 )
        .style("text-anchor", "middle")
		 .style("font-size", "14px")
        .text('ct'); 
		
		svg.append("text")
    .attr("x", (width -10 ))             
    .attr("y", height)
    .attr("text-anchor", "middle")  
    .style("font-size", "14px")
    .text('Hello'); */
	  
   svg.append("g")
          .attr("class", "x axis")
          .style("stroke", "white")
          .attr("transform", "translate(0," + height + ")")
          .call(xAxis)
	/*	  .append("text")      // text label for the x axis
     //   .attr("x", width -10 )
        .attr("y", height-30 )
        .attr("text-anchor", "middle")
		.style("font-size", "4px")
        .text('cgg');  */

   svg.append("g")
          .attr("class", "y axis")
           .style("stroke", "white")
          //  .style("fill", "white")
          .call(yAxis)

       /* svg.append("text")
          .attr("transform", "rotate(-90)")
          .attr("y", 6)
          .attr("dy", ".71em")
          .style("text-anchor", "end")
          .text("memroey"); */ 
		  
		  


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

	
  }

  formatDate() {
    this.data.forEach(ms => {
      console.log("HI" + ms);
      if (typeof ms.timeCatureed === 'string') {
        console.log("String" +  ms.timeCatureed)
        ms.timeCatureed = this.parseDate(ms.timeCatureed);
         console.log("date" +  ms.timeCatureed)

      }
    });
  } 
    formatDate2() {
    this.cpuData.forEach(ms => {
      console.log("HI" + ms);
      if (typeof ms.timeCatureed  === 'string') {
        console.log("String" +  ms.timeCatureed)
        ms.timeCatureed = this.parseDate(ms.timeCatureed);
         console.log("date" +  ms.timeCatureed)

      }
    });
  }
  
  
  drawChart() {
	 
	   
	  var m = [100, 10, 10, 60],
  w = 1000 - m[1] - m[3],
  h = 300 - m[0] - m[2];

//var x = d3.scalePoint().range([0, w]).padding(.1),
var x= d3.scaleBand().rangeRound([0, w]),
  y = {},
  dragging = {};

var line = d3.line(),
  background,
  foreground;

var svg = d3.select(this.chartElement.nativeElement).append("svg:svg")
  .attr("width", w + m[1] + m[3])
  .attr("height", h + m[0] + m[2])
  .append("svg:g")
  .attr("transform", "translate(" + m[3] + "," + m[0] + ")");

var data = [{

  "A": 200, 
        "B": 3000, 
        "C": 2300, 
        "D": 4320, 
        "E": 1230, 
        "F": 7400, 
        "G": 1431, 
        "H": 1400, 
        "I": 4300, 
        "J": 6750
}, {

 "A": 1002, 
        "B": 2003, 
        "C": 2773, 
        "D": 3432, 
        "E": 1673, 
        "F": 740, 
        "G": 1231, 
        "H": 1900, 
        "I": 3000, 
        "J": 675
}];

// Extract the list of dimensions and create a scale for each.
x.domain(this.dimensions = d3.keys(data[0]).filter(function(d) {
  if (d === "name") return false;
  if (d === "Plant" || d === "Chemical" || d === "Pathway" || d === "Gene" || d === "Disease") {
    y[d] = d3.scaleOrdinal()
      .domain(data.map(function(p) {
        return p[d];
      }))
      .range([h, 0]);
  } else {
    y[d] = d3.scaleLinear()
      .domain(d3.extent(data, function(p) {
        return +p[d];
      }))
      .range([h, 0]);
  }
  return true;
}));

// Add grey background lines for context.
background = svg.append("svg:g")
  .attr("class", "background")
  .selectAll("path")
  .data(data)
  .enter().append("svg:path")
  .attr("d", path.bind(this));
 // .attr("d", path); 

// Add blue foreground lines for focus.
foreground = svg.append("svg:g")
  .attr("class", "foreground")
  .selectAll("path")
  .data(data)
  .enter().append("svg:path")
   .attr("d", path.bind(this));
 // .attr("d", path);

// Add a group element for each dimension.
var g = svg.selectAll(".dimension")
  .data(this.dimensions)
  .enter().append("svg:g")
  .attr("class", "dimension")
  .attr("transform", function(d) {
    return "translate(" + x(d) + ")";
  }) 

// Add an axis and title.
g.append("svg:g")
  .attr("class", "axis")
  .each(function(d) {
    d3.select(this).call(d3.axisLeft(y[d]));
  })
  .append("svg:text")
  .attr("text-anchor", "middle")
  .attr("y", -50)
  .attr("x",-10)
  .text(String);

function position(d) {
  var v = dragging[d];
  return v == null ? x(d) : v;
}

function transition(g) {
  return g.transition().duration(500);
}

// Returns the path for a given data point.
function path(d) {
  return line(this.dimensions.map(function(p) {
    return [position(p), y[p](d[p])];
  }));
}
}
}