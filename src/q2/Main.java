package q2;
import java.util.ArrayList;
import java.util.Arrays;

import q2.option.GotGardenOption;
import q2.option.IOption;


public class Main {
	public static void main(String[] args) {
		AbstractApartment hisAparment = new ApartmentDecorator(
				new SmallApartment(12),
				new ArrayList<IOption>(Arrays.asList(new GotGardenOption())));
	}
}
