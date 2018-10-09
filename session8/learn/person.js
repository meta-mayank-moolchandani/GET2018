"use strict";

class Person{
    constructor(fname,lname){
        this.fname = fname;
        this.lname = lname;
    }

    set name(name){
        let x = name.split(" ");
        this.fname = x[0];
        this.lname = x[1];
    }

    get name(){
        return this.fname + "-" + this.lname;
    }

}

class Student extends Person{
    constructor(fname,lname,batch){
        super(fname,lname);
        this.batch = batch;
    }
}
