public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Firm firm = new Firm();
        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        // creating employee1
        Employee employee1 = new Employee();
        employee1.setName("Harry");
        employee1.setSurname("Kane");
        employee1.setDaysoff(13);
        employee1.addAnIncome(2022, "March", 2450);
        employee1.addAnIncome(2022, "April", 2350);

        // creating employee2
        Employee employee2 = new Employee();
        employee2.setName("Raheem");
        employee2.setSurname("Sterling");
        employee2.setDaysoff(14);
        employee2.addAnIncome(2022, "February", 3400);
        employee2.addAnIncome(2022, "March", 3400);
        employee2.addAnIncome(2022, "April", 3510);

        // creating employee3
        Employee employee3 = new Employee();
        employee3.setName("Jadon");
        employee3.setSurname("Sancho");
        employee3.setDaysoff(17);
        employee3.addAnIncome(2022, "April", 3110);

        // creating manager1
        Manager manager1 = new Manager();
        manager1.setName("Steven");
        manager1.setSurname("Gerrard");
        manager1.setDaysoff(15);
        manager1.setBonusdaysoff(11);
        manager1.addAnIncome(2022, "January", 4800);
        manager1.addAnIncome(2022, "February", 7380);
        manager1.addAnIncome(2022, "March", 7400);
        manager1.addAnIncome(2022, "April", 7810);

        // adding members in team1 (1 manager and 3 employees)
        team1.addNewManager(manager1);
        team1.addNewEmployee(employee1);
        team1.addNewEmployee(employee2);
        team1.addNewEmployee(employee3);

        // now the team is a part of the firm
        firm.addTeam(team1);

        System.out.println("--------------- Initial size of team  ---------------");
        System.out.println(team1.getEmployees().size());
        System.out.println("-----------------------------------------------------");
        System.out.println();
        // fire up an employee
        team1.fireUpEmployee(employee3);
        // fire up a manager
        team1.fireUpManager(manager1);


        System.out.println("--------------- Final size of team  ---------------");
        System.out.println(team1.getEmployees().size());
        System.out.println("-----------------------------------------------------");
        System.out.println();

        System.out.println("--------------- Promotion of an employee ---------------");
        // currently, team1 doesn`t have a manager and it is a must to have it
        // we are looking at our employees and we will promote one of them to manage the team
        director.promoteEmployee(employee2, team1);
        System.out.println("--------------------------------------------------------");
        System.out.println();

        // creating manager2
        Manager manager2 = new Manager();
        manager2.setName("Frank");
        manager2.setSurname("Lampard");
        manager2.setDaysoff(20);
        manager2.setBonusdaysoff(20);
        manager2.addAnIncome(2022, "January", 4000);
        manager2.addAnIncome(2022, "February", 6200);
        manager2.addAnIncome(2022, "March", 6140);
        manager2.addAnIncome(2022, "April", 6020);

        // creating manager3
        Manager manager3 = new Manager();
        manager3.setName("Alex");
        manager3.setSurname("Ferguson");
        manager3.setDaysoff(18);
        manager3.setBonusdaysoff(6);
        manager3.addAnIncome(2022, "January", 6900);
        manager3.addAnIncome(2022, "February", 8200);
        manager3.addAnIncome(2022, "March", 8350);
        manager3.addAnIncome(2022, "April", 8500);

        // creating employee4
        Employee employee4 = new Employee();
        employee4.setName("Jamie");
        employee4.setSurname("Vardy");
        employee4.setDaysoff(5);
        employee4.addAnIncome(2022, "April", 2980);

        // adding members in team2 (2 managers and 1 employee)
        team2.addNewEmployee(employee4);
        team2.addNewManager(manager2);
        team2.addNewManager(manager3);

        System.out.println("--------------- Relegate manager ---------------");
        // there are too many managers and the team is in need of employees
        // so we relegate one of the managers
        director.relegateManager(manager2, team2);
        System.out.println("------------------------------------------------");
        System.out.println();

        System.out.println("--------------- Go on vacation ---------------");
        // the manager that was relegated by the director needs a vacation
        // to get over the decision of the boss, so he requests 10 days of rest
        team2.getEmployees().get(team2.getEmployees().size() - 1).requestVacation(director, 10);
        System.out.println("----------------------------------------------");
        System.out.println();

        System.out.println("--------------- Statistic over all the workers ---------------");
        System.out.println("--------------- regarding the days of vacation ---------------");
        for (Employee employee : team2.getEmployees()) {
            employee.accept(director);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        System.out.println("--------------- A big request of vacation which ---------------");
        System.out.println("------------------ couldn`t be accomplished -------------------");
        manager3.requestVacation(director, 100);
        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        firm.addTeam(team2);

        System.out.println("--------------- Income of a manager in a certain period ---------------");
        // check the venues of a manager in a specific year and month
        director.viewIncomeHistory(manager3, 2022, "March");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();

        System.out.println("--------------- Income of an employee in a certain period ---------------");
        director.viewIncomeHistory(employee4, 2022, "April");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();

        System.out.println("--------------- Income of an employee in a period ---------------");
        System.out.println("---------------- that he didn`t work for the firm ---------------");
        director.viewIncomeHistory(employee4, 2021, "April");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        // adding some empty teams
        firm.addTeam(team3);
        firm.addTeam(team4);

        System.out.println("--------------- Initial structure of firm  ---------------");
        System.out.println(firm.getTeams());
        System.out.println("----------------------------------------------------------");
        System.out.println();
        // delete all the empty teams
        firm.deleteTeam();

        System.out.println("--------------- Final structure of firm  ---------------");
        System.out.println(firm.getTeams());
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }
}
