public abstract class Actions {
    public abstract void viewIncomeHistory(Employee employee, int year, String month);
    public abstract void giveVacationTo(Employee employee, int numberOfDays);
    public abstract void promoteEmployee(Employee employee, Team team);

    public abstract void viewIncomeHistory(Manager manager, int year, String month);
    public abstract void giveVacationTo(Manager manager, int numberOfDays);
    public abstract void relegateManager(Manager manager, Team team);
}
