package phonebook;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;



public class телефонная_книга_на_Java {

    public static void main(String[] args) {
        
        Map<String, ArrayList<String>> telephonebook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Добро пожаловать в телефонную книгу! Ознакомьтесь с командами:");
        System.out.println("add_new - добавить новый контакт");
        System.out.println("add_phone - добавить телефон к существующему контакту");
        System.out.println("find - найти контакт по имени");
        System.out.println("del_contact - удалить контакт полностью");
        System.out.println("all - вывести всю телефонную книгу");

        while (true) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();

            if (command.contains("add_new")){
                add_new(telephonebook);
            }

            else if (command.contains("add_phone")){
                add_phone(telephonebook);
            }

            else if (command.contains("find")){
                find(telephonebook);
            }

            else if (command.contains("all")){
                all(telephonebook);
            }

            else if (command.contains("del_contact")){
                del_contact(telephonebook);
            }


            else {
                System.out.println("Упс! Кажется такой команды нет. Напомню:");
                System.out.println("add_new - добавить новый контакт");
                System.out.println("add_phone - добавить телефон к существующему контакту");
                System.out.println("find - найти контакт по имени");
                System.out.println("del_contact - удалить контакт полностью");
                System.out.println("all - вывести всю телефонную книгу");
            }

            
        }

    }


    private static void add_new(Map<String, ArrayList<String>> telephonebook){
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Введите имя контакта");
        String name = scanner.nextLine();
        // telephonebook.put(name, new ArrayList<String>());
        telephonebook.computeIfAbsent(name, k -> new ArrayList<String>());

        System.out.println("Введите номер телефона");
        String phone = scanner.nextLine();
        telephonebook.get(name).add(phone);
        System.out.println("Контакт "+ name +" с номером "+phone+" успешно создан!");


    }

    private static void add_phone(Map<String, ArrayList<String>> telephonebook){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя контакта");
        String name = scanner.nextLine();

        System.out.println("Введите номер телефона контакта");
        String phone = scanner.nextLine();

        telephonebook.get(name).add(phone);

        System.out.println("Контакту "+ name +" успешно добавлен новый номер "+phone);
        

    }



    private static void find(Map<String, ArrayList<String>> telephonebook) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя контакта");
        String name = scanner.nextLine();

        if (telephonebook.containsKey(name)){
            System.out.println(name + "=" + telephonebook.get(name));
        }
        else {
            System.out.println("в телефонной книге нет такого контакта!");
        }
        
    }


    private static void del_contact(Map<String, ArrayList<String>> telephonebook) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя контакта");
        String name = scanner.nextLine();

        telephonebook.remove(name);

        System.out.println("Контакт "+ name + " успешно удален!");

    }


    private static void all(Map<String, ArrayList<String>> telephonebook) {
        TreeMap<String, ArrayList<String>> treemap_telephonebook = new TreeMap<>(Comparator.reverseOrder());
        treemap_telephonebook.putAll(telephonebook);        
        System.out.println(treemap_telephonebook);

    }




}
