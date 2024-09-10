package DesignPatterns.Structural.Proxy;

public class EmployeeDaoProxy implements EmployeeDao{

    private EmployeeDaoImp employeeDaoImp;

    public EmployeeDaoProxy(EmployeeDaoImp employeeDaoImp) {
        this.employeeDaoImp = employeeDaoImp;
    }

    @Override
    public void create(String client, Employee employee) throws Exception {
        if(client.equals("ADMIN")){
            employeeDaoImp.create(client, employee);
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, Employee employee) throws Exception {
        if(client.equals("ADMIN")){
            employeeDaoImp.delete(client, employee);
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void get(String client, int employeeId) throws Exception {
        if(client.equals("USER") || client.equals("ADMIN")){
            employeeDaoImp.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}
