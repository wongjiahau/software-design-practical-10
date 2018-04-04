package q1;

public class AdminStaff extends PersonalDetails {

    public AdminStaff(int monthlySalary) {
        setMonthlySalary(monthlySalary);
    }

    private void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int calculateBonus() {
        return 2 * monthlySalary;
    }

    public void showRemainingLeave(int daysApplied) {
        System.out.println("Leave remaining is : " +
                            (20 - daysApplied) + " days");
    }
}
