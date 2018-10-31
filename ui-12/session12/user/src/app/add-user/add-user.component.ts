import { Component, OnInit,Input } from '@angular/core';
import { User } from '../User';
import {UserService} from '../user.service';
import {Location} from '@angular/common'
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})

export class AddUserComponent implements OnInit {
  @Input() user = new User();


  constructor(public userService:UserService, private location:Location, public route: ActivatedRoute) {
      this.route.params.subscribe( params => this.initializeUser(params["id"]));
   }
  
  ngOnInit() {
    
    
  }
  
  goBack(){
    this.location.back();
  }

  addUser(){
    if(this.user.id==null){
      this.userService.addUser(this.user).subscribe(()=>this.goBack());
    }else{
      this.userService.updateUser(this.user).subscribe(()=>this.goBack());
    }  
  }

  initializeUser(userId){
    if(userId!=null){
      this.userService.getUser(userId).subscribe((data:User)=>this.user = data);
    }
  }



}
