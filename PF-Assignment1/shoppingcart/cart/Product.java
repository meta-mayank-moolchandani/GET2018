package cart;

/*this class is used to store the details of the products*/

public class Product {
	public String productName;
	public int productPrice;
	public int productQuantity;
	
	
	public Product(String productName,int productPrice,int productQuantity){
		this.productName=productName;
		this.productPrice=productPrice;
		this.productQuantity=productQuantity;
	}
	
	public String toString(){
		return "Product Name:"+this.productName + "\tProduct Price:" +this.productPrice + "\tProduct Quantity:" + this.productQuantity; 
	}
}
