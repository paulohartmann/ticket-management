import { User } from './user.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class UserService {

 private baseUrl = environment.BACKEND_URL + '/user';

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string){
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    });
  }

  create(user: User): Observable<User> {
    console.log("service" + user)
    return this.http.post<User>(this.baseUrl, user);
  }
}
