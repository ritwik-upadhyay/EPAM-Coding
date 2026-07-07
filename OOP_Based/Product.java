public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    public Product() {
        this(0,"Unknown",0.0);
    }
    public Product(int productId,String productName,double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public int getProductId() {
        return this.productId;
    }
    public String getProductName() {
        return this.productName;
    }
    public double getProductPrice() {
        return this.productPrice;
    }
    public void display() {
        System.out.println("Product "+this.getProductId()+" Details:");
        System.out.println("Product ID: "+this.getProductId());
        System.out.println("Product Name: "+this.getProductName());
        System.out.println("Product Price: "+this.getProductPrice());
        System.out.println();
    }
    public static void main(String[] args) {
        Product p1 = new Product();
        p1.display();
        Product p2 = new Product(23,"Cornflakes",3.57);
        p2.display();
    }
}