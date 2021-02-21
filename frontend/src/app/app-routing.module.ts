import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './views/dashboard/dashboard.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { LoginComponent } from './views/login/login.component';
import { DashboardHomeComponent } from './views/dashboard-home/dashboard-home.component';
import { UserCreateComponent } from './user/user-create/user-create.component';

export const routes: Routes = [
  { path: 'user-create',      component: UserCreateComponent },
  { path: 'login',      component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'dashboard-home',      component: DashboardHomeComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full'},
      { path: 'dashboard',      component: DashboardComponent },
      { path: 'user-profile',      component: UserProfileComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
