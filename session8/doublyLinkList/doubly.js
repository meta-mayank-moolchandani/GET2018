"use strict"





class Node{
    constructor(element){
        this.data = element;
        this.next = null;
        this.previous = null;
    }
}

class DoublyLinkedList{
    constructor(){
        this.head = null;
        this.size=0;
    }
}

DoublyLinkedList.prototype.addElement = function addElement(element){
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
        tempNode.previous = currentNode;
        this.size++;
    }
}

DoublyLinkedList.prototype.show = function(){
   // debugger;
    if(this.size===0){
        return "list is empty";
    }else{
        let currentNode = this.head;
        let arr= [];
        while(currentNode!=null){
            arr.push(currentNode.data);
            currentNode = currentNode.next;
        }
        return arr;
    }
}

DoublyLinkedList.prototype.remove = function(position){
    if(position<0 || position>this.size-1){
        return "invalid position";
    }else{
        let currentNode = this.head;
        let previousNode = currentNode;
        let index = 0;
        if(this.size===1){
            currentNode = null;
            this.size--;
        }else{
            if(position===0){
                this.head =currentNode.next;
                this.size--;
            }else{
                while(index<position){
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                    index++;               
                }
                if(currentNode.next===null){
                    previousNode.next=null;
                    currentNode.previous=null;
                    this.size--;

                }else{
                    currentNode = currentNode.next;
                    previousNode.next = currentNode;
                    currentNode.previous = previousNode;

                    this.size--;
                }
            }
        }
    }
}

/**
 list = new DoublyLinkedList();
 list.addElement(5);
 list.addElement(10);
 list.addElement(15);
 list.show();

 list.remove(1000);

 list.remove(1);
 list.show();

 list.remove(0);
 list.show();s
 */