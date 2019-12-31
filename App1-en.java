import java.util.ArrayList;
import java.util.Scanner;


public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("The number of parameters:");
		String n = input.nextLine();
		
	//there is an array for every parameter; elements of array - possible values of one parameter; 
		
	    ArrayList<String[]> allArrays = new ArrayList<String[]>(); 
	    //an array that contain arrays of parameter values 
	    //allArrays.add(names); - how to add a new array for one parameter (its values)
	    
		for(int i = 0; i < Integer. parseInt(n); i++) {
			System.out.println("¬ведите название " + (i+1) + " параметра:");   
			String pname = input.nextLine(); 
			System.out.println("¬ведите количество допустимых значений:");   
			String nz = input.nextLine(); 
			String[] zmass = new String[Integer. parseInt(nz)+1]; //array of values
			System.out.println("¬ведите через Enter возможные значени€:");  
			zmass[0]=pname; //zero element of array is the parameter name
			for(int j = 1; j <= Integer. parseInt(nz); j++)
			{
				zmass[j] = input.nextLine();
			}
			//entered an array
			allArrays.add(zmass);//added an array of values of one parameter to array of parameters
			}
		
	  /*  for (String a[]:allArrays){
	    	   System.out.println("It is new parameter");
	        for (String b:a){
	            System.out.println(b);
	        }
	    }*/
		System.out.println("How many objects to you want to create?");
		String nobjects = input.nextLine();
		for (int t = 0; t<Integer.parseInt(nobjects); t++)
		{
		System.out.println("  " );
		System.out.println("THE OBJECT WAS GENERATED:" );
	    for (int i = 0; i<allArrays.size(); i++){
	    	   String value[] = allArrays.get(i); //array of values for i parameter
	    	   System.out.println(value[0] + ":" );
	    	   int ng = 1; //low limit for random number generation
	    	   int vg = value.length-1; //up limit 
	    	   int rand = ng + (int) ( Math.random() * vg); //random number is a number of value
	    	   System.out.println(value[rand]);
	    }
	}
	}
}


