package q1;

public class SalesStaffAdapter extends PersonalDetails {
	private PersonalDetails person;
	private SalesStaff salesStaff;
	public SalesStaffAdapter(PersonalDetails person, int salesTotal, int numYearsTraining, 
            int numSalesAssignment) {
		this.person = person;
		this.salesStaff =  new SalesStaff(salesTotal, numYearsTraining, numSalesAssignment);
	}
	
	public int calculateBonus() {
		return salesStaff.calculateCommission();
	}
    public void showRemainingLeave(int daysApplied) {
    	
    }
}
