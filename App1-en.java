import java.util.ArrayList;
import java.util.Scanner;


public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Number of parameters:");
		String n = input.nextLine();
		
	//for each parameter there is an array; elements of array are possible values for this parameter; 
		
	    ArrayList<String[]> allArrays = new ArrayList<String[]>(); 
	    //an array that contain all parameter-arrays 
	    //allArrays.add(names); - how to add a new parameter-array
	    
		for(int i = 0; i < Integer. parseInt(n); i++) {
			System.out.println("Name of " + (i+1) + " parameter:");   
			String pname = input.nextLine(); 
			System.out.println("Number of possible values:");   
			String nz = input.nextLine(); 
			String[] zmass = new String[Integer. parseInt(nz)+1]; //array of values
			System.out.println("Use Enter and write possible values:");  
			zmass[0]=pname; //zero element of an array is the name of parameter
			for(int j = 1; j <= Integer. parseInt(nz); j++)
			{
				zmass[j] = input.nextLine();
			}
			//entered all values
			allArrays.add(zmass);//added this parameter-array (contains values) to all arrays
			}
		
	  /*  for (String a[]:allArrays){
	    	   System.out.println("Its new parameter");
	        for (String b:a){
	            System.out.println(b);
	        }
	    }*/
		System.out.println("How many objects do you want to generate?");
		String nobjects = input.nextLine();
		for (int t = 0; t<Integer.parseInt(nobjects); t++)
		{
		System.out.println("  " );
		System.out.println("NEW OBJECT WAS GENERATED:" );
	    for (int i = 0; i<allArrays.size(); i++){
	    	   String value[] = allArrays.get(i); //array of values for i parameter
	    	   System.out.println(value[0] + ":" );
	    	   int ng = 1; //low limit for number generation
	    	   int vg = value.length-1; //up limit
	    	   int rand = ng + (int) ( Math.random() * vg); //random number is the number of value in an array
	    	   System.out.println(value[rand]);
	    }
	}
	}
}


