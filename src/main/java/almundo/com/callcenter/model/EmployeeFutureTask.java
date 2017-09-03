package almundo.com.callcenter.model;

import java.util.concurrent.FutureTask;

/**
 * Created by mariano on 20/08/17.
 */
public class EmployeeFutureTask extends FutureTask<EmployeeFutureTask> implements Comparable<EmployeeFutureTask> {

    private Employee employee;

    public EmployeeFutureTask(Employee employee) {
        super(employee, null);
        this.employee = employee;
    }

    public int compareTo(EmployeeFutureTask o) {
        return this.employee.getPrior() - o.getEmployee().getPrior();
    }

    public Employee getEmployee() {
        return this.employee;
    }
}
