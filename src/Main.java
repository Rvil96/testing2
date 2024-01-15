import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Введите выражение формата а+b, где значение а и b должно находится в диапозоне от 1 до 10.\n" +
                "В формате арабских цифр или римских. Для завершение команды введите Exit.");
        Culcl x = new Culcl();// объявляем объект класса
        Scanner scr = new Scanner(System.in);
        String input = "input";



            do{
                input = scr.nextLine();// запрашиваем строку

                String operation = x.test(input);// вызываю метод тест для определения операции

                String result = x.test2(operation, input);// медот выполнения операции

                System.out.println(result);
            }while (!input.equals("Exit"));


        }
    }
