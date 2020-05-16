import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { ForgotPassComponent } from './forgot-pass/forgot-pass.component';
import { FeedbackPageComponent } from './feedback-page/feedback-page.component';

const routes: Routes = [
  { path: '', redirectTo: '/login-page', pathMatch: 'full' },
  { path: 'login-page', component: LoginPageComponent },
  { path: 'register-page', component: RegisterPageComponent},
  { path: 'navigation-bar', component: NavigationBarComponent},
  { path: 'forgot-pass', component: ForgotPassComponent},
  { path: 'feedback-page', component: FeedbackPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
