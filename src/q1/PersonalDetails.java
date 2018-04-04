package q1;
public abstract class PersonalDetails {
    protected int monthlySalary;
	
    public int getMonthlySalary() {
    	  return monthlySalary;
    }
    
    public abstract int calculateBonus();
    public abstract void showRemainingLeave(int daysApplied);
} 

