class Node{
    constructor(element){
        this.data = element;
        this.next = null;
    }
}

class LinkedList{
    constructor(){
        this.head = null;
        this.size = 0;
    }
}

/**
 * 
 * @param {add element to the linklist} element 
 */
LinkedList.prototype.addElement = function(element){
//    debugger;
    let tempNode = new Node(element);
    let currentNode = this.head;

    if(currentNode===null){
        this.head = tempNode;
        this.size++;
    }else{
        while(currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next = tempNode;
        this.size++;

    }
}

/**
 * 
 * @param {positon of an element which is going to be removed} position 
 */
LinkedList.prototype.remove = function(position){
    let currentNode = this.head;
    if(position<0 || position>=this.size){
        return "invalid position";
    }else{
        if(position===0){
            this.head = currentNode.next;
            this.size--;
        }else{
            let index = 0;
            let previousNode = currentNode;
            while(index<position){
                previousNode = currentNode;
                currentNode = currentNode.next;
                index++;
            }
            previousNode.next = currentNode.next;
            this.size--;
        }
    }
}

LinkedList.prototype.show = function(){
    if(this.head===null){
        return "list is empty";
    }else{
        let currentNode = this.head;
        let index = 0;
        let arr = [];
        while(index<this.size){
            arr.push(currentNode.data);
            currentNode = currentNode.next;
            index++;
        }
        return arr;
    }
}



/**
 list = new LinkedList();
 list.addElement(5);
 list.addElement(10);
 list.addElement(15);

 list.show();

 list.remove(0);
 list.remove(2);
 list.remove(57);
 list.show();
 */