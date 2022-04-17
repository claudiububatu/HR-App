import java.util.ArrayList;

public class Employee implements Visitable {
    private String name;
    private String surname;
    private ArrayList<SalaryHistory> income = new ArrayList<>();
    private int daysoff;
    private int bonusdaysoff;

    public Employee() { }

    public Employee(final String name, final String surname, final int daysoff) {
        this.name = name;
        this.surname = surname;
        this.daysoff = daysoff;
    }

    public Employee(final String name, final String surname,
                    ArrayList<SalaryHistory> income, final int daysoff) {
        this.name = name;
        this.surname = surname;
        this.income = income;
        this.daysoff = daysoff;
    }

    public int getBonusdaysoff() {
        return bonusdaysoff;
    }

    public void setBonusdaysoff(final int bonusdaysoff) {
        this.bonusdaysoff = bonusdaysoff;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public ArrayList<SalaryHistory> getIncome() {
        return income;
    }

    public void setIncome(final ArrayList<SalaryHistory> income) {
        this.income = income;
    }

    // function built for adding an income into the arraylist
    public void addAnIncome(final int year, final String month, final int salary) {
        this.income.add(new SalaryHistory(year, month, salary));
    }

    public int getDaysoff() {
        return daysoff;
    }

    public void setDaysoff(final int daysoff) {
        this.daysoff = daysoff;
    }

    public int totalVacation() {
        return this.bonusdaysoff + this.daysoff;
    }

    // function built to notify the director that one employee
    // is requesting numberOfDays for vacation
    public void requestVacation(final Director director, final int numberOfDays) {
        director.giveVacationTo(this, numberOfDays);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", income=" + income +
                ", daysoff=" + daysoff +
                ", bonusdaysoff=" + bonusdaysoff +
                '}';
    }
}
