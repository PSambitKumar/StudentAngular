package HB;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();  
		Transaction transaction  = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstname("Sambit");
		employee.setlastname("Pradhan");
		
		session.save(employee);
		transaction.commit();
		System.out.print("Data Inserted!!");
		session.close();
		factory.close();
		
	}
}
