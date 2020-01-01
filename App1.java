import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class App1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество параметров:");
        String n = input.nextLine();

        //для каждого параметра - массив; элементы массива - допустимые значения параметра;
        //пока массивы одномерные, чтобы настроить связи между значениями, нужно
        //увеличивать мерность массива

        HashMap<String, ArrayList<String>> allArrays = new HashMap<>();
        //словарь соответствий параметр : массив возможных значений
        //allArrays.put(String pname, ArrayList<String> values); - так добавить туда новый параметр.

        for (int i = 0; i < Integer.parseInt(n); i++) {
            System.out.println("Введите название " + (i + 1) + " параметра:");
            String pname = input.nextLine();
            ArrayList<String> value = new ArrayList<>();//массив значений
            System.out.println("Введите через Enter возможные значения:");
            for (String j = input.nextLine(); !j.equals("") || value.size() <= 0; j = input.nextLine()) {
                value.add(j);
            }
            //ввели массив
            allArrays.put(pname, value);//добавили массив значений в массив параметров
        }
		
	  /*  for (String a[]:allArrays){
	    	   System.out.println("Пошел новый параметр");
	        for (String b:a){
	            System.out.println(b);
	        }
	    }*/
        System.out.println("Сколько объектов вы хотите сгенерировать?");
        String nobjects = input.nextLine();
        for (int t = 0; t < Integer.parseInt(nobjects); t++) {
            System.out.println("  ");
            System.out.println("СГЕНЕРИРОВАННЫЙ ОБЪЕКТ:");
            for (int i = 0; i < allArrays.size(); i++) {
                Set<String> val = allArrays.keySet(); //получаем множество названий параметров
                ArrayList<String> values = new ArrayList<>();
                val.forEach(g -> values.add(g)); //сохраняем его в массив.
                System.out.print(values.get(i) + ": ");//выводим название массива
                int ng = 1; //нижняя граница генерации числа
                int vg = allArrays.get(values.get(i)).size() - 1;//получаем длину массива возможных значений по конкретному ключу
                int rand = ng + (int) (Math.random() * vg); //получение случайного значение от 1 до количества значений по данному параметру.
                System.out.println(allArrays.get(values.get(i)).get(rand));
            }
        }
    }
}


