import java.util.ArrayList;
import java.util.Scanner;


public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Введите количество параметров:");
		String n = input.nextLine();
		
	//для каждого параметра - массив; элементы массива - допустимые значения параметра; 
		//пока массивы одномерные, чтобы настроить связи между значениями, нужно
		//увеличивать мерность массива
		
	    ArrayList<String[]> allArrays = new ArrayList<String[]>(); 
	    //массив из массивов всех параметров    
	    //allArrays.add(names); - так добавить туда новый массив для одного параметра
	    
		for(int i = 0; i < Integer. parseInt(n); i++) {
			System.out.println("Введите название " + (i+1) + " параметра:");   
			String pname = input.nextLine(); 
			System.out.println("Введите количество допустимых значений:");   
			String nz = input.nextLine(); 
			String[] zmass = new String[Integer. parseInt(nz)+1]; //массив значений
			System.out.println("Введите через Enter возможные значения:");  
			zmass[0]=pname; //нулевой элемент массива - название параметра
			for(int j = 1; j <= Integer. parseInt(nz); j++)
			{
				zmass[j] = input.nextLine();
			}
			//ввели массив
			allArrays.add(zmass);//добавили массив значений в массив параметров
			}
		
	  /*  for (String a[]:allArrays){
	    	   System.out.println("Пошел новый параметр");
	        for (String b:a){
	            System.out.println(b);
	        }
	    }*/
		System.out.println("Сколько объектов вы хотите сгенерировать?");
		String nobjects = input.nextLine();
		for (int t = 0; t<Integer.parseInt(nobjects); t++)
		{
		System.out.println("  " );
		System.out.println("СГЕНЕРИРОВАННЫЙ ОБЪЕКТ:" );
	    for (int i = 0; i<allArrays.size(); i++){
	    	   String value[] = allArrays.get(i); //массив значений i параметра
	    	   System.out.println(value[0] + ":" );
	    	   int ng = 1; //нижняя граница генерации числа
	    	   int vg = value.length-1; //верхняя граница
	    	   int rand = ng + (int) ( Math.random() * vg); //случайное число - номер значения
	    	   System.out.println(value[rand]);
	    }
	}
	}
}


