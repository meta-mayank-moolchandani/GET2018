var Stack = function(size){
    this.size = size;
    this.stack = new Array(5);
    this.top = -1;

    this.push = function(element){
        if(this.top===size-1){
            return "stack is full";
        }else{
            this.stack[++this.top]=element;
        }
    }

    this.pop = function(element){
        if(this.top===-1){
            return false;
        }else{
            this.top--;
            return true;
        }
    }

    this.show = function(){
        if(this.top==-1){
            return "empty stack";
        }else{
            var newStack = new Array(this.top+1);
            for(let index = 0; index<=this.top; index++){
                newStack[index] = this.stack[index]; 
            }
            return newStack;
        }
    }

    this.peek = function(){
        return this.stack[this.top];
    }
}

/*
  x = new Stack(5);
  x.pop();
  x.show();
*/
/*
  x.push(4);
  x.push(3);
  x.push(2);
  x.show();
*/
  
 /* 
  x.pop();
  x.peek();
*/
  
/*
  x.push(7);
  x.push(8);
  x.push(10);
  x.show();
*/

/*  
x.push(12);
 */
