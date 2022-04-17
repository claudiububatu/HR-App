public class Director extends Actions implements Visitor {
    @Override
    public void visit(final Employee employee) {
        System.out.println("Number of vacation days left for " + employee.getName() + " " +
                            employee.getSurname() + " is: " + employee.totalVacation());
    }

    @Override
    public void visit(final Manager manager) {
        System.out.println("Number of vacation days left for " + manager.getName() + " " +
                            manager.getSurname() + " is: " + manager.totalVacation());
    }

    public void promoteEmployee(final Employee employee, final Team team) {
        Manager manager = new Manager(employee.getName(), employee.getSurname(),
                employee.getIncome(), employee.getDaysoff(), employee.getBonusdaysoff());
        team.fireUpEmployee(employee);
        team.addNewManager(manager);
        System.out.println(manager.getName() + " " + manager.getSurname() + " has been promoted to manager rank.");
    }

    public void relegateManager(final Manager manager, final Team team) {
        Employee employee = new Employee(manager.getName(), manager.getSurname(),
                manager.getIncome(), manager.getDaysoff());
        team.fireUpManager(manager);
        team.addNewEmployee(employee);
        System.out.println(employee.getName() + " " + employee.getSurname() + " has been relegated to employee rank.");
    }

    public void giveVacationTo(final Manager manager, int numberOfDays) {
        if (numberOfDays > manager.totalVacation()) {
            System.out.println("You have only " + (manager.getDaysoff() + manager.getBonusdaysoff()) +
                    " days of vacation!");
            System.out.println("You will receive " + (manager.getDaysoff() + manager.getBonusdaysoff())
                    + " days of vacation!");
            manager.setDaysoff(0);
            manager.setBonusdaysoff(0);

        } else {
            if (numberOfDays > manager.getDaysoff()) {
                numberOfDays -= manager.getDaysoff();
                manager.setDaysoff(0);
                manager.setBonusdaysoff(manager.getBonusdaysoff() - numberOfDays);
                System.out.println(manager.getName() + " " + manager.getSurname() + " has "
                        + manager.getBonusdaysoff() + " remaining days of vacation.");
            } else {
                int x = manager.getDaysoff();
                manager.setDaysoff(x - numberOfDays);
                System.out.println(manager.getName() + " " + manager.getSurname() + " has "
                        + (manager.getDaysoff() + manager.getBonusdaysoff()) + " remaining days of vacation.");
            }
        }
    }

    public void giveVacationTo(final Employee employee, int numberOfDays) {
        if (numberOfDays > employee.totalVacation()) {
            System.out.println("You have only " + (employee.getDaysoff() + employee.getBonusdaysoff()) +
                    " days of vacation!");
            System.out.println("You will receive " + (employee.getDaysoff() + employee.getBonusdaysoff())
                    + " days of vacation!");
            employee.setDaysoff(0);
        } else {
            int daysLeft = employee.getBonusdaysoff() + employee.getDaysoff() - numberOfDays;
            employee.setDaysoff(daysLeft);
            System.out.println(employee.getName() + " " + employee.getSurname() + " has "
                    + employee.getDaysoff() + " remaining days of vacation.");
        }
    }

    public void viewIncomeHistory(final Employee employee, final int year, final String month) {
        int ok = 0;
        for (SalaryHistory salaryhistory : employee.getIncome()) {
            if (salaryhistory.getYear() == year && salaryhistory.getMonth().equals(month)) {
                ok = 1;
                System.out.println("The employee " + employee.getName() + " " + employee.getSurname()
                        + " has received " + salaryhistory.getSalary() + " money by " + month + " " + year);
                break;
            }
        }

        if (ok == 0) {
            System.out.println(employee.getName() + " " + employee.getSurname() +
                    " wasn`t hired at our firm at that time!");
        }
    }

    public void viewIncomeHistory(final Manager manager, final int year, final String month) {
        int ok = 0;
        for (SalaryHistory salaryhistory : manager.getIncome()) {
            if (salaryhistory.getYear() == year && salaryhistory.getMonth().equals(month)) {
                ok = 1;
                System.out.println("The manager " + manager.getName() + " " + manager.getSurname()
                        + " has received " + salaryhistory.getSalary() + " money by " + month + " " + year);
                break;
            }
        }

        if (ok == 0) {
            System.out.println(manager.getName() + " " + manager.getSurname() +
                    " wasn`t hired at our firm at that time!");
        }
    }
}
