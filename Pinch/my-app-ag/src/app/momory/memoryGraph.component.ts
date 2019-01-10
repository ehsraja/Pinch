import { Component, Input } from '@angular/core';

@Component({
  selector: 'memoryGraph',
  templateUrl: './memoryGraph.component.html',
  styleUrls: ['./momory.component.scss'],
 
})
export class MemoryGraphComponent {
  
   @Input()
  data:any = [];
} 