import { RouterModule, Routes } from '@angular/router';
import { ReportsListComponent } from './reports-list/reports-list.component';
import { ReportsViewComponent } from './reports-view/reports-view.component';
import { GraphComponent } from './graph/graph.component';
import { AppsComponent } from './apps/apps.component';
import { StatsComponent } from './stats/stats.component';

const routes: Routes = [
  { 
     path: 'curves', 
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
     path: 'appStats', 
     component: StatsComponent 
   }
];

export const routing = RouterModule.forRoot(routes);