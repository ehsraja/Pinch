import { Component, Input } from '@angular/core';
import { OnInit,ViewEncapsulation,ViewChildren,ViewChild,ElementRef,QueryList,AfterViewInit ,OnChanges,ChangeDetectionStrategy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as d3 from 'd3';
import * as scale from 'd3-scale';

@Component({
  selector: 'statsGraph',
  templateUrl: './statsGraph.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush 
 
})
export class StatsGraphComponent {
  
   @Input()
   apps:any = [];

    @ViewChildren('divs') 
    divs: QueryList<ElementRef> ;

   constructor( private http: HttpClient ) { 
 console.log("4");
 

   }

    ngOnInit() {
    console.log("5");
       console.log(" Hi graph " + this.apps);
      
      console.log("sds" + this.divs.length);

  }
   
} 