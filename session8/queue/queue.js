function Queue(){
    this.queue = [];

    this.enqueue = function(element){
        this.queue.push(element);
        return true;
    }

    this.dequeue = function(){
        if(this.queue.length===0){
            return "queue is empty";
        }else{
            this.queue.shift();        
            return true;
        }
    }

}

/**
 
 queue = new Queue();
 
 queue.dequeue();
 queue.enqueue(10);
 queue.enqueue(10);

 queue.queue;
 */