package designpatterns.javapatterns.structural.proxy;

public interface EmployeeDao {

    public void create(String client, Employee employee) throws Exception;
    public void delete(String client, Employee employee) throws Exception;
    public void get(String client, int employeeId) throws Exception;
}
