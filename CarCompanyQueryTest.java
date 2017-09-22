import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import database.Test1;
import database.Test2;


public class CarCompanyQueryTest 
{
	   public static void main(String[] args) 
	   {
	      Result test1 = JUnitCore.runClasses(Test1.class);
	      
	      for (Failure failure : test1.getFailures()) 
	      {
	          System.out.println(failure.toString());
	       }
	      System.out.println(test1.wasSuccessful());
	      
	      Result test2 = JUnitCore.runClasses(Test2.class);
	      
	      for (Failure failure : test2.getFailures()) 
	      {
	          System.out.println(failure.toString());
	       }
	      System.out.println(test2.wasSuccessful());
	      
	   }
	}
	