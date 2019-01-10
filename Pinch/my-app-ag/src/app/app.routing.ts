import { RouterModule, Routes } from '@angular/router';
import { ReportsListComponent } from './reports-list/reports-list.component';
import { ReportsViewComponent } from './reports-view/reports-view.component';
import { GraphComponent } from './graph/graph.component';
import { AppsComponent } from './apps/apps.component';
import { MomoryComponent } from './momory/momory.component';

const routes: Routes = [
  { 
     path: 'reports', 
     component: ReportsListComponent 
   },
   {
    path: 'reports/:name',
    component: ReportsViewComponent
  },
  { 
     path: 'application', 
     component: AppsComponent 
   },
  { 
     path: 'graphs/:name', 
     component: GraphComponent 
   },
     { 
     path: 'memory', 
     component: MomoryComponent 
   }
];

export const routing = RouterModule.forRoot(routes);