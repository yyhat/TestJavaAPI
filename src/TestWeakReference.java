import java.lang.ref.WeakReference;

/**
 * @des: test WeakReference
 * @author anting.hu
 * @date: 2015-10-17
 * @reference: http://www.tuicool.com/articles/imyueq
 */
public class TestWeakReference {
	public static void main(String[] args) {
		Car car = new Car(150000, "red");
		WeakReference<Car> weakCar = new WeakReference<Car>(car);
		
		int i=0;
		while(true)
		{
			if(weakCar.get() != null)
				System.out.println("Object is alive for "+i+" loops - "+weakCar);
			else
			{
				System.out.println("weakCar is gc");
				break;
			}
		}
	}

}

class Car {
	  private double price;
	  private String colour;
	  
	  public Car(double price, String colour){
	    this.price = price;
	    this.colour = colour;
	  }
	  
	  public double getPrice() {
	    return price;
	  }
	  public void setPrice(double price) {
	    this.price = price;
	  }
	  public String getColour() {
	    return colour;
	  }
	  public void setColour(String colour) {
	    this.colour = colour;
	  }
	  
	  public String toString(){
	    return colour +"car costs $"+price;
	  }
	  
	}
