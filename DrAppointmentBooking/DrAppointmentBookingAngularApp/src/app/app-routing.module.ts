import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AppointmentComponent} from "./components/appointment/appointment.component";

const routes: Routes = [
  {path : "home", component : AppointmentComponent},
  {path : "", redirectTo : "home", pathMatch : "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
