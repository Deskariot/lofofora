import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

/**
 * класс таблицы
 */
public class Abilities {
    private HashMap<String, ArrayList<String>> abils;
    private ArrayList<String> keys;


    public Abilities() {
        abils = new HashMap<>();
        keys = new ArrayList<>();
    }

    /**
     * копирует другую таблицу
     * @param defAbil - другая таблица
     */
    public Abilities(Abilities defAbil) {
        abils = defAbil.abils;
        keys = defAbil.keys;
    }

    /**
     * Открывает существующую таблицу
     * @param path - путь к существующей таблице
     * @throws IOException - проброс исключения потока ввода-вывода
     */
    public Abilities(String path) throws IOException {
        abils = new HashMap<>();
        keys = new ArrayList<>();
        Reader in = new FileReader(path); // поток чтения из файла
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT); // парсер таблицы, лежащей в файле
        List<CSVRecord> records = parser.getRecords(); //получаем массив строк таблицы
        CSVRecord tempKeys = records.get(0); //первая строка - заголовок(наши ключи)
        records = records.subList(1,records.size()); //оставляем только значения в таблице
        for (int i =0;i<tempKeys.size();i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (CSVRecord record : records) {
                if (!record.get(i).equals("-")) //если есть значение, записывает
                    temp.add(record.get(i));
            }
            put(tempKeys.get(i), temp); //помещает в таблицу новую связку ключ-массив значений.
        }
    }

    /**
     * Установка пары ключ-массив значений
     * @param pname - имя характеристики
     * @param values - возможные варианты
     */
    public void put(String pname, ArrayList<String> values) {
        if (!pname.equals("")) {
            abils.put(pname, values);
            keys.add(pname);
        }
    }

    /**
     * Сохраняет таблицу по указанному пути
     * @throws IOException - проброс исключения ввода-вывода
     */
    public void save() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // поток буферного ввода
        System.out.println("Введите имя файла");
        String filename = bufferedReader.readLine();
        FileWriter out = new FileWriter(filename + ".csv"); // поток записи файла
        String[] header = new String[getKeys().size()]; //заголовки будющего файла csv
        for (int i = 0; i < header.length; i++)
            header[i] = getKeys().get(i);
        CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(header)); //создание объекта-принтера для записи таблицы.
        for (int i = 0; i < getMaxSize(); i++) {
            List<String> temp = new ArrayList<>();
            for (String key : getKeys()) {
                temp.add(i < get(key).size() ? get(key).get(i) : "-"); // формирование строк таблицы(если варианты какой-то характеристики закончились, пишет -
            }
            printer.printRecord(temp); //запись строки в таблицу
        }
        out.close();// закрытие потока записи
    }

    public int size() {
        return abils.size();
    }

    /**
     * получает максимальное количество вариантов характеристик(по сути длину самого длинного столбца таблицы)
     * @return максимальная длина
     */
    public int getMaxSize() {
        int max = 0;
        for (String key : getKeys()) {
            max = get(key).size() > max ? get(key).size() : max;
        }
        return max;
    }

    /**
     * выдает ключи
     * @return - массив ключей
     */
    public ArrayList<String> getKeys() {
        return keys;
    }

    /**
     * выдает значение по ключу
     * @param key - ключ
     * @return - значение
     */
    public ArrayList<String> get(String key) {
        return abils.get(key);
    }


}
