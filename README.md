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
    public SalesStaffAdapter(SalesStaff salesStaff)
}
```
