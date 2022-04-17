public class SalaryHistory {
    private int year;
    private String month;
    private int salary;

    public SalaryHistory(int year, String month, int salary) {
        this.year = year;
        this.month = month;
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "SalaryHistory{" +
                "year=" + year +
                ", month='" + month + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
