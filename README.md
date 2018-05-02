# software-design-practical-10
## Design Patterns Problems

## 2014 Q1 (c) (modified from C# code) (13 marks)
A software development team (Team A) is creating a payroll application. One major theme in their design is the use of a common interface which will be implemented by the various classes that represent different types of staff. This simplifies collection and processing of objects from these classes in a generalised fashion. Figure 1.1 illustrates this approach; while Figure 1.2 demonstrates how these objects are added and processed from a generic typed List.

Another development team (Team B) working independently from Team A has created a class (Figure 1.3) representing another category of staff which they use in a different application. Team A would like to reuse this class in their payroll application, and they have noted these key points after discussion with Team B:
Instead of getting a bonus like other staff, sales staff obtain a commission instead.
The leave available to a sales staff is based on this formula:
20 + number of sales assignments + number of years in training.

Team B has given Team A to reuse the SalesStaff class on condition that they do not alter it in any way. On the other hand, Team A also does not wish to modify their existing code or design approach in order to reuse this new class.

Suggest a suitable design pattern that allows the SalesStaff class to be used by Team A that meets these two requirements. Write the code to demonstrate this pattern, making sure you include statements in the main() method to show how this approach works with the use of the personList generic typed list. If your answer includes code segments from the original application, you do not have to repeat this in your answer: just include a simple comment to indicate this.

## Answer
Adapter pattern.

```java
public class SalesStaffAdapter extends PersonalDetails {
    private SalesStaff salesStaff;
    public SalesStaffAdapter(SalesStaff salesStaff) {
        this.salesStaff = salesStaff;
    }
    public int getMonthlySalary() {
    	  return monthlySalary;
    }
    
    public abstract int calculateBonus(){
        return salesStaff.calculateCommission();
    }

    public void showRemainingLeave(int daysApplied) {
        // ignore daysApplied
        int result = 20 + getNumSalesAssignment() + getNumYearsTraining().
        System.out.println(result);
    }
}
```
```java
public class Program {
    public static void main(String [] args) {
        List<PersonalDetails> personList =
               new ArrayList<PersonalDetails>();
        AdminStaff adam = new AdminStaff(2000);
        ManagementStaff peter = new ManagementStaff(3000);
        AdminStaff mary = new AdminStaff(4000);

        // Added the following line
        SalesStaffAdapter ali = new SalesStaffAdapter(new SalesStaff());

        personList.add(adam);
        personList.add(peter);
        personList.add(mary);

        // Added the following line
        personList.add(ali);

        for(PersonalDetails pd : personList) {
            System.out.println("Monthly bonus is " + pd.calculateBonus());
            pd.showRemainingLeave(15);
        }
    }
}
```

## 2014 Q5 (c) (modified from C# code) (15 marks)

The class hierarchy shown in Figure 5.1 is used to model different types of apartments available for sale in a newly developed condominium block. The price of each apartment type is available via the price instance variable. In addition to the two basic types of apartments available (StandardApartment and SmallApartment), potential buyers can also opt for additional options to be added on to either of these two types. These options, and the corresponding extra payment required, are as follows:

|Add-on option| Additional amount to be paid|  
|--|--|
|Garden|View of KLCC|
|5000|15000|


As an example, a standard apartment with a garden would cost 55,000 while a small apartment with both the options (garden and view) would cost 50,000.

### (i) Suggest a design pattern that allows the modelling of these additional options and their prices without introducing new instance variables into the existing hierarchy. Write out the additional code that you will need in this scenario based on this particular pattern.
Answer: Decorater pattern
```java
public class ApartmentDecorator {
    private AbstractApartment apartment;
    private boolean gotGarden;
    private boolean gotKlccView;

    public ApartmentDecorator(AbstractApartment apartment, boolean gotGarden, boolean gotKlccView) {
        this.apartment = apartment;
        this.gotGarden = gotGarden;
        this.gotKlccView = gotKlccView;
    }

    public int getPrice() {
        double finalPrice = 0;
        finalPrice += apartment.getPrice();
        if(gotGarden) {
            finalPrice += 5000;
        }
        if(gotKlccView) {
            finalPrice += 15000;
        }
        return finalPrice;
    }
}
```

### (ii) Write some statements to go in the main() method that shows the use of this pattern to create an object representing a small apartment with a garden and a view and which returns the correct price of the apartment. 
Answer below.
```java
public class Main {
    public static void main(String[] args) {
        // Ali wants to buy small apartment with no extra options
        IApartment aliPunyaApartment =
            new ApartmentDecorator(new SmallApartment(), false, false);
        
        // Abu wants to buy a standard apartment with KlccView but no need garden
        IApartment abuPunyaApartment = 
            new ApartmentDecorator(new StandardApartment(), false, true);
        
        double priceThatAliNeedToPay = aliPunyaApartment.getPrice();

        double priceThatAbutNeedToPay = abuPunyaApartment.getPrice();
    }
}
```

## Answer for 2015 Q2 (b) (15 marks)
```java
public abstract class Item {
    private String name;
    public Item(String name) {
        this.name = name;
    }
    public abstract double getPrice();
    public abstract void addItem();
}

public class Component extends Item {
    private double price;

    public Component(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void addItem() {
        throw new Exception("You cannot add item to a component.");
    }

    @Override
    public String toString() {
        return this.name + "(cost" this.price ")";
    }
}

public class Assembly extends Item {
    private ArrayList<Item> children;

    public Assembly(String name) {
        super(name);
        this.children = new ArrayList<Item>();
    }

    @Override
    public double getPrice() {
        double finalPrice = 0;
        foreach(Item item : children) {
            finalPrice += item.getPrice();
        }
        return finalPrice;
    }

    @Override 
    public String toString() {
        String finalResult = "";
        finalResult += return this.name 
                    + " is a collection. The components in it are: \n";
        foreach(Item item : children) {
            finalResult += item.toString() + "\n";
        }
        return finalResult;
    }
}
```
## Answer for 2016 Q2 (a)(i) (12 marks)
The design pattern we need to use is Singleton.
We use Singleton for this situation because we one to make sure the DatabaseConnection instance is only created once throughout the whole application, this is because they are resource-expensive, so we don't want to recreate them everytime we need to use it.

The code is as the following:
```java
public class DatabaseConnection {
    private static DatabaseConnection singletonInstance;

    // In Singleton, you must make sure the constructor is private, 
    // so that you can't call new DatabaseConnection outside of this class
    private DatabaseConnection() {
        // create the database connection
    }

    public static DatabaseConnection getInstance() {
        if(singletonInstance == null) {
            singletonInstance = new DatabaseConnection();
        }
        return singletonInstance; 
    }
}
```

## Answer for 2016 Q2 (a)(ii) (12 marks)
Use adapter pattern.


## Answer for 2016 Q5 (a) (20 marks)
Composite pattern.