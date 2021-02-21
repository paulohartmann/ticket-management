import { User } from './../user.model';
import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit {

  user: User = {
    userId: null,
    password: '',
    userName: '',
    email: '',
    jobTitle: '',
    role: 'DEFAULT'
  }

  //Autowired (injeção de dependência para UserService)
  constructor(private userService: UserService, private dialogRef: MatDialogRef<UserCreateComponent>){

   }

  ngOnInit() {
  }

  createUser(): void{
    this.userService.create(this.user).subscribe(() =>{
      this.userService.showMessage('User created!')
      this.dialogRef.close(this.user);
    });
  }

  close() {
    this.dialogRef.close();
  }

}
