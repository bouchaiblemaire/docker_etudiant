package fr.einfolearning.employee_crud.resources;


import fr.einfolearning.employee_crud.beans.Employee;
import fr.einfolearning.employee_crud.db.dao.EmployeeDAOImpl;
import fr.einfolearning.employee_crud.db.dao.IEmployeeDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/employees")
public class EmployeeRessource {

	private IEmployeeDAO employeeDAO;
	

	@GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/list")
	public List<Employee> listAllEmployee()
	{
            
            System.out.println("Entering listAllEmployees");
	
            List<Employee> employees = null;
            
            try {
           this.employeeDAO = new EmployeeDAOImpl();
            
		
	
		
	employees = employeeDAO.getAllEmployees();
	System.out.println("Getting listAllEmployees");
	System.out.println("listAllEmployees employees size ==>" + employees);
		
		
        
            }
            catch (SQLException e){
                e.printStackTrace();
            }
		//request.setAttribute("employees", employees);
		//redirectToList(request, response);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("employeeView.jsp");		
		//dispatcher.forward(request, response);
                
                finally{
                return employees;
            }

	}
        
        
	@GET
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/get/{id}")
	public Employee getEmployee(@PathParam("id") int id) 
	{
		System.out.println("Entering getEmployee");
		
	
		System.out.println("getEmployee, employeeId==>" + id);
	
                   System.out.println("Entering listAllEmployees");
	
            Employee employee = null;
            
            try {
           this.employeeDAO = new EmployeeDAOImpl();
            
		
	
		employee = employeeDAO.getEmployee(id);		
		System.out.println("getEmployee, employee details==>" + employee);
		
		
            }
            catch (SQLException e){
                e.printStackTrace();
            }
	
                
                finally{
                return employee;
            }

	}
        
        
        @POST
        @Consumes(MediaType.TEXT_PLAIN)
        @Path("/insert/{name}/{address}/{email}/{phone}")
	public void insertEmployee(
                @PathParam("name") String name,
                @PathParam("address") String address,
                @PathParam("email") String email,
                @PathParam("phone") String phone
                
                ) throws WebApplicationException
	{
		System.out.println("Entering insertEmployee");
            
            try {
           this.employeeDAO = new EmployeeDAOImpl();
            
		
		Employee employee = new Employee(name, address, email, phone);
                System.out.println(employee);
		boolean result = employeeDAO.addEmployee(employee);
		System.out.println("insertResult result ==>" + result);				
		 }
            catch (SQLException e){
                throw new WebApplicationException("L'insertion de l'employe n'a pu avoir lieur", Response.Status.BAD_REQUEST);
            }
	
	}
        
        
        
	
        
}
