import java.util.ArrayList;

public class Firm {
    ArrayList<Team> teams = new ArrayList<>();

    public Firm() { }

    public Firm(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void showVacation(Team team) {
        Visitor vacationVisitor = new Director();
        for (Employee employee : team.getEmployees()) {
            employee.accept(vacationVisitor);
        }
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void deleteTeam() {
        this.teams.removeIf(team -> team.getEmployees().size() == 0);
    }

    @Override
    public String toString() {
        return "Firm{" +
                "teams=" + teams +
                '}';
    }
}
