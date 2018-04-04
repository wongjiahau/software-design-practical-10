package q2;

public abstract class AbstractApartment implements IApartment {
    protected int price;    
    private String apartmentStyle;
    private int aptNumber;

    public AbstractApartment(int aptNumber) {
        this.aptNumber = aptNumber;
    }

    public int getApartmentNumber() {
        return aptNumber;
    }

    public abstract int getPrice();
} 
