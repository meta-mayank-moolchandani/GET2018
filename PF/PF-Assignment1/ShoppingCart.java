import java.util.*;

class Item{
	String ItemName;
	int price;
	int quantity;
	//int effectivePrice;
	
	
	void updateQuantity()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("enter ther new quantity");
		quantity = sc.nextInt();
		System.out.print("Item Updated");
	}
	
	
	Item()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Details of Item: \n");
		
		System.out.print("Item Name: ");
		ItemName = sc.next();
		System.out.print("Price: ");
		price = sc.nextInt();
		System.out.print("Quantity: ");
		quantity=sc.nextInt();
		System.out.println("\n");
	}
	
	void showItem()
	{
		System.out.println("Item name:"+ ItemName + "\tQuantity:" + quantity + "\tprice:" + price + "\t\teffective price:" + effectivePrice());
		
	}
	int effectivePrice()
	{
		//effectivePrice = 
		return  price*quantity;
	}	
}

public class ShoppingCart {
	static Scanner sc = new Scanner(System.in);
	ListNode head;
	int size;

	class ListNode
	{
		ListNode next;
		Item item;
		
		ListNode(Item obj)
		{
			//obj = new Item();
			item = obj;
			next = null;
		}
		
	}
	
	ShoppingCart()
	{
		head=null;
		size = 0;
		
	}
	
	void insert()
	{
		Item i = new Item();
		ListNode temp = new ListNode(i);
		if(size==0)
		{
			head = temp;
			size+=1;
		}else
		{
			temp.next=head;
			head=temp;
			size+=1;
		}
	}
	
	void show()
	{
		if(head==null){
			System.out.print("cart is empty: ");
		}else{
			ListNode temp = head;
			while(temp!=null){
				temp.item.showItem();
				temp = temp.next;
				
			}	
	    }
	}
	
	void remove()
	{
		if(head==null)
		{
			System.out.println("Cart is empty: \n");
		}else
		{
			System.out.print("enter item name: ");
			String rm = sc.next();
			if(head.next==null)
			{
				if(head.item.ItemName.equals(rm))
				{
					System.out.println("item removed \n");
					head=null;
					size--;
				}else{
					System.out.print("item is not found\n");
				}
			}else
			{
				ListNode temp = head;
				while(temp.next!=null && (!(temp.next.item.ItemName.equals(rm))))
				{
					temp=temp.next;
				}
				if(temp.next==null)
				{
					System.out.print("Item is not found in cart\n");
					
				}else
				{
					ListNode x = temp.next;
					temp.next = x.next;
					size--;
					System.out.println("item removed \n");
					
				}
				
			}
			
		}

	}
	
	void update()
	{
		if(head==null)
		{
			System.out.println("cart is empty:\n");
			
		}else
		{
			System.out.print("enter item name: ");
			String rm = sc.next();
			
			if(head.next==null)
			{
				if(head.item.ItemName.equals(rm))
				{
					head.item.updateQuantity();
				}else
				{
					System.out.println("No such Item has found: \n");
				}
				
			}else
			{
				ListNode temp = head;
				while(temp.next!=null && (!(temp.next.item.ItemName.equals(rm))))
				{
					temp=temp.next;
				}
				if(temp.next==null)
				{
					System.out.print("Item is not found in cart\n");
					
				}else
				{
					temp = temp.next;
					temp.item.updateQuantity();
					System.out.print("Item updated successfully: \n");
			    }
		    }
		}
			
		
	}

	
	void checkout()
	{
		if(head==null)
		{
			System.out.print("cart is empty, total amount is: 0 \n");
		}else
		{
		  int sum = 0;
		  ListNode temp = head;
		  
		  while(temp!=null)
		  {
			  sum = sum+temp.item.effectivePrice();
			  temp=temp.next;
		  }
		  
		  System.out.println("Total payable amount : " + sum );
		}
		
	}	
	
	
	
    public static void main(String[] args) {
    	ShoppingCart scart  = new ShoppingCart();
    	int ch;
    	Scanner sc = new Scanner(System.in);
    	while(true)
    	{
    		System.out.println("1: Insert Item: ");
    		System.out.println("2: Show Item: ");
    		System.out.println("3: Remove Item: ");
    		System.out.println("4: Update Item: ");
    		System.out.println("5: Checkout cart: ");
    		ch = sc.nextInt();
    		
    		switch(ch)
    		{
    			case 1: scart.insert();
    			        break;
    			case 2: scart.show();
    			        break;
    			case 3: scart.remove();
    			        break;
    			case 4: scart.update();
    			        break;
    			case 5: scart.checkout();
    			        System.exit(1);
    			        break;
    		    default: System.out.println("Invalid Choice: ");	                        
    			                        
    			
    		}
    		
    	}
        
    }
}
