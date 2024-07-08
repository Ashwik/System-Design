package DesignPatterns.Structural.Proxy;

public class EmployeeDaoImp implements EmployeeDao{

    @Override
    public void create(String client, Employee employee) {
        System.out.println("created: "+ employee.toString());
    }

    @Override
    public void delete(String client, Employee employee) {
        System.out.println("deleted: "+ employee.toString());
    }

    @Override
    public void get(String client, int employeeId) {
        System.out.println("employee: "+ employeeId);
    }
}
