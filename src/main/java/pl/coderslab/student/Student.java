package pl.coderslab.student;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private boolean mailingList;
    private List<String> programmingSkills;
    public Student(){}
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public List<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(List<String> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName +
                ",lastName=" + lastName + "]";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
