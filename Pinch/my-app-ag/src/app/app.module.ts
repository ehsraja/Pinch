import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ReportsListComponent } from './reports-list/reports-list.component';
import {routing} from "./app.routing";
import { ReportsViewComponent } from './reports-view/reports-view.component';
import { GraphComponent } from './graph/graph.component';
import { AppsComponent } from './apps/apps.component';

@NgModule({
  declarations: [
    AppComponent,
    ReportsListComponent,
    ReportsViewComponent,
    GraphComponent,
    AppsComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,AgGridModule.withComponents([]), routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
