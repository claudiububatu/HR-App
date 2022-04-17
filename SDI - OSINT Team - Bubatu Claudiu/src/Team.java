import java.util.ArrayList;
import java.util.Iterator;

public class Team {
    ArrayList<Employee> employees = new ArrayList<>();

    public Team() { }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addNewEmployee(final Employee employee1) {
        this.employees.add(employee1);
    }

    public void addNewManager(final Manager manager) {
        this.employees.add(manager);
    }

    // function built for firing up an employee using iterator
    public void fireUpEmployee(final Employee employee) {
        Iterator<Employee> itr = this.employees.iterator();
         while (itr.hasNext()) {
             Employee employee1 = itr.next();
             if (employee1.getSurname().equals(employee.getSurname())
                     && employee1.getName().equals(employee.getName())) {
                itr.remove();
             }
         }
    }

    // function built for firing up a manager using collection
    public void fireUpManager(final Manager manager) {
        this.employees.removeIf(employee -> employee.getSurname().equals(manager.getSurname())
                && employee.getName().equals(manager.getName()));
    }

    @Override
    public String toString() {
        return "Team{" +
                "employees=" + employees +
                '}';
    }
}
