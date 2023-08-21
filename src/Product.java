public class Product {
  
  private String name;
  private Double price;
  private Integer quantity;

  public Product(String name, Double price, Integer quantity){
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public Double price() {
    return this.price;
  }

  public void setPrice(Double price){
    this.price = price;
  }

  public Integer quantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity){
    this.quantity = quantity;
  }

  public double total(){
    Double total = this.price * this.quantity;
    return total;
  }

}
