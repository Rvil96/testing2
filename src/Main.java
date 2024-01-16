import java.util.Scanner;
/*Коментарий для проверяющего, если это решение не правильное. При прошлой проверке не было исключений.
* Я сделал свой класс LocalException, который наследуется от Exception, и
* использовал его везде где только можно, не конкретизируя каждое исключение.
* Так же добавил некоторые комментарии, например то что метод toRome взят из интернета */

public class Main {
    public static void main(String[] args) throws LocalException {

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
//x.convertToArab("f");

        }
    }
