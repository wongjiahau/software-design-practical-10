package q2;
import java.util.ArrayList;

import q2.option.IOption;

public class ApartmentDecorator extends AbstractApartment {
	private AbstractApartment apartment;
	private ArrayList<IOption> addOnOptions;

	public ApartmentDecorator(AbstractApartment apartment, ArrayList<IOption> addOnOptions) {
		super(apartment.getApartmentNumber());
		this.apartment = apartment;
		this.addOnOptions = addOnOptions;
	}

	public int getPrice() {
		int finalPrice = this.apartment.getPrice();
		for (IOption option : this.addOnOptions) {
		    finalPrice += option.getPrice();
		}
		return finalPrice;
	}

}
