import java.util.ArrayList;

public class Manager extends Employee {
    private int bonusdaysoff;
    public Manager() { }

    public Manager(final String name, final String surname, final int daysoff, final int bonusdaysoff) {
        super(name, surname, daysoff);
        this.bonusdaysoff = bonusdaysoff;
    }

    public Manager(final String name, final String surname, ArrayList<SalaryHistory> income,
                   final int daysoff, final int bonusdaysoff) {
        super(name, surname, income, daysoff);
        this.bonusdaysoff = bonusdaysoff;
    }

    @Override
    public int getBonusdaysoff() {
        return bonusdaysoff;
    }

    @Override
    public void setBonusdaysoff(final int bonusdaysoff) {
        this.bonusdaysoff = bonusdaysoff;
    }

    public int totalVacation() {
        return this.getBonusdaysoff() + getDaysoff();
    }

    public void accept(final Visitor v) {
        v.visit(this);
    }

    // function built to notify the director that one manager
    // is requesting numberOfDays for vacation
    public void requestVacation(final Director director, final int numberOfDays) {
        director.giveVacationTo(this, numberOfDays);
    }
}
