import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserDetailsComponent } from './user-details/user-details.component';
import {AddUserComponent} from './add-user/add-user.component'
import{AuthGuard} from './auth.guard'

const routes: Routes = [
  {
    path: '',
    redirectTo:'/allUsers',
    pathMatch:'full',
  },
  {
    path:'allUsers',
    component:UserDetailsComponent
  },
  {
    path:'addUser',
    component:AddUserComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'addUser/:id',
    component:AddUserComponent,
    canActivate:[AuthGuard]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
