import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.csv.*;

public class App1 {


    public static void main(String[] args) {

        try {
            Abilities abilities = new Abilities("names.csv");
            //printToConsole(abilities);
            abilities.save();
        } catch (IOException ignored) {
            System.out.println("Что-то пошло не так... Проверь потоки ввода-вывода");
        }
    }

    /**
     * Метод, считывающий таблицу от юзера с консоли
     * @return - Считанная таблица
     */
    public static Abilities readFromConsole() {
        Abilities allArrays = new Abilities();
        System.out.println("Введите количество параметров:");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String n = input.readLine();
            //для каждого параметра - массив; элементы массива - допустимые значения параметра;
            //пока массивы одномерные, чтобы настроить связи между значениями, нужно
            //увеличивать мерность массива


            //словарь соответствий параметр : массив возможных значений
            //allArrays.put(String pname, ArrayList<String> values); - так добавить туда новый параметр.

            for (int i = 0; i < Integer.parseInt(n); i++) {
                System.out.println("Введите название " + (i + 1) + " параметра:");
                String pname = input.readLine();
                ArrayList<String> value = new ArrayList<>();//массив значений
                System.out.println("Введите через Enter возможные значения:");
                for (String j = input.readLine(); !j.equals("") || value.size() <= 0; j = input.readLine()) {
                    value.add(j);
                }
                //ввели массив
                allArrays.put(pname, value);//добавили массив значений в массив параметров
            }
        } catch (IOException ignored) {
        }

        return allArrays;
    }

    /**
     * Метод, выводящий таблицу в консоль.
     * @param abilities - таблица, которую нужно напечатать.
     */
    public static void printToConsole(Abilities abilities) {
        Scanner input = new Scanner(System.in);
        System.out.println("Сколько объектов вы хотите сгенерировать?");
        String nobjects = input.nextLine();
        for (int t = 0; t < Integer.parseInt(nobjects); t++) {
            System.out.println("  ");
            System.out.println("СГЕНЕРИРОВАННЫЙ ОБЪЕКТ:");
            for (int i = 0; i < abilities.size(); i++) {
                ArrayList<String> values = abilities.getKeys();//получаем множество названий параметров
                System.out.print(values.get(i) + ": ");//выводим название массива
                int ng = 1; //нижняя граница генерации числа
                int vg = abilities.get(values.get(i)).size() - 1;//получаем длину массива возможных значений по конкретному ключу
                int rand = ng + (int) (Math.random() * vg); //получение случайного значение от 1 до количества значений по данному параметру.
                System.out.println(abilities.get(values.get(i)).get(rand));
            }
        }
    }
}


