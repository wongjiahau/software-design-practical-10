package q1;
import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String [] args) {
        List<SalesStaffAdapter> personList =
               new ArrayList<SalesStaffAdapter>();
        AdminStaff adam = new AdminStaff(2000);
        ManagementStaff peter = new ManagementStaff(3000);
        AdminStaff mary = new AdminStaff(4000);

        personList.add(new SalesStaffAdapter(adam, 10, 10, 10));
        personList.add(new SalesStaffAdapter(peter, 20, 20, 20));
        personList.add(new SalesStaffAdapter(mary, 30, 30, 30));

        for(PersonalDetails pd : personList) {
            System.out.println("Monthly bonus is " + pd.calculateBonus());
            pd.showRemainingLeave(15);
        }
    }
}
