package q1;

public class ManagementStaff extends PersonalDetails {

    public ManagementStaff(int monthlySalary) {
        setMonthlySalary(monthlySalary);
    }

    private void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int calculateBonus() {
        return 3 * monthlySalary;
    }

    public void showRemainingLeave(int daysApplied) {
        System.out.println("Leave remaining is : " + 
                             (30 - daysApplied) + " days");
    }
} 
