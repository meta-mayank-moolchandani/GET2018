import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  constructor(public userService:UserService,private route: ActivatedRoute, private router: Router) { }

  users:any = [];
  ngOnInit() {
    localStorage.setItem('role','admin');
    this.getUsers();
    
  }
  getUsers() {
    this.users = [];
    this.userService.getUsers().subscribe((data: {}) => {
      console.log(data);
      this.users = data;
    });
  }

}
