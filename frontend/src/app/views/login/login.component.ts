import { User } from './../../user/user.model';
import { MatDialogConfig } from '@angular/material/dialog';
import { MatDialog } from '@angular/material/dialog';
import { UserCreateComponent } from './../../user/user-create/user-create.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {

  }

  openDialog(){
    const dialogNewUserConfig = new MatDialogConfig();

    dialogNewUserConfig.disableClose = true;
    dialogNewUserConfig.autoFocus = true;
    dialogNewUserConfig.hasBackdrop = true;
    dialogNewUserConfig.minWidth = 800;

    const dialogRef = this.dialog.open(UserCreateComponent, dialogNewUserConfig);
    dialogRef.afterClosed().subscribe(
      user => this.user
    );
  }

}
