package q1;

public class SalesStaff {
    private int salesTotal;
    private int numYearsTraining;
    private int numSalesAssignment;

    public SalesStaff(int salesTotal, int numYearsTraining, 
                       int numSalesAssignment) {
        this.salesTotal = salesTotal;
        this.numYearsTraining = numYearsTraining;
        this.numSalesAssignment = numSalesAssignment;
    }
    
    public int getSalesTotal() {
    	  return salesTotal;
    }
    
    public int getNumYearsTraining() {
    	  return numYearsTraining;
    }

    public int getNumSalesAssignment() {
    	  return numSalesAssignment;
    }
    
    public int calculateCommission() {
        return numSalesAssignment * salesTotal / 10;
    }
}
