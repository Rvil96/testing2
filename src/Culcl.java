/*Коментарий для проверяющего, если это решение не правильное. При прошлой проверке не было исключений.
 * Я сделал свой класс LocalException, который наследуется от Exception, и
 * использовал его везде где только можно, не конкретизируя каждое исключение.
 * Так же добавил некоторые комментарии, например то что метод toRome взят из интернета */
public class Culcl {
    int x;
    int y;

    boolean theRome = false; // чек является ли строка ввода римской или арабской

    String test(String input){ //метод по определению операции
        char[] arr = input.toCharArray();// разбиваем ввод на массив что бы найти знак выражения
        String s ="notFound";// строка для возврата

        for (char c : arr) {//цикля для прохождения по массиву

            if (c == '+') {
                s = "\\+";
            } else if (c == '-') {
                s = "\\-";
            } else if (c == '/') {
                s = "\\/";
            } else if (c == '*') {
                s = "\\*";
            }
        }

        return s;// возвращаем значение
    }

    String test2 (String a, String b) throws LocalException {// метод выполнения операции и конвертации, если нужно
        int result = 0;
        if ( b.equals("Exit")){// условие для завершения работы
            return "Exit";
        }
        if(a.equals("notFound")){// исключение если не найден знак
            throw new LocalException("Вы не ввели знак операции");
        }
        String[] numbs = b.split(a);
        if(numbs.length>2){// исключение при вводе более 2х знаков выражения
            throw new LocalException("Вы ввели более 2х знаков выражения");
        }
        if(isNumeric(numbs[0]) && isNumeric(numbs[1])){// чек на арабский или риский ввод
            x = Integer.parseInt(numbs[0]);// перевод строки в  инт
            y = Integer.parseInt(numbs[1]);
        } else {
            x = convertToArab(numbs[0]);// конвертация в арабский для выполнения операции
            y = convertToArab(numbs[1]);
            theRome = true;//перевод булевого значение, если ввод не цифрами
        }


         if((x>0 && x<11) && (y>0 && y<11)) {// условие от 1 до 10

             switch (a) { // выполнение операции
                 case "\\+":
                     result = x + y;
                     break;
                 case "\\-":
                     result = x - y;
                     break;
                 case "\\/":
                     result = x / y;
                     break;
                 case "\\*":
                     result = x * y;
                     break;
             }
         }
         else {
             throw new LocalException("Некорректный ввод");// исключение при некорректном вводе
         }
        if(theRome){//перевод обратно в римское исчесление
            if(result <= 0){// условие исключения при отрицательнов выводе
                throw new LocalException("throw Exception в римском исчеслении нет отрицательных значений.");
            }
            return convertToRome(result);// перевод обратно в риское исчесление, если ввод был на римском и возвращение результата
        }
        return Integer.toString(result); // возвращаем результат

    }

    String convertToRome(int number)  {// конвертация в римские цифры

        int[] numbs = {100, 90, 50, 40, 10, 9, 5, 4, 1};// создаем соотносящиеся массивы
        String[] keys = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();//создаем динамическую строку, для ее создания

        int x = 0;
        while (x< keys.length){// ЭТО РЕШЕНИЕ ВЗЯТО ИЗ ИНТЕРНЕТА
            while (number>=numbs[x]){
                int y = number/numbs[x];
                number= number%numbs[x];
                for (int k=0; k<y; k++){
                    str.append(keys[x]);
                }
            }
            x++;
        }
        return str.toString();
    }

    int convertToArab (String str) throws LocalException { // ковертация в арабские цифры тут все просто
        int num=0;// возвращаем ноль для проверки на исключение
        switch (str){
            case "X":
                num = 10;
                break;
            case "IX":
                num = 9;
                break;
            case "VIII":
                num = 8;
                break;
            case "VII":
                num = 7;
                break;
            case "VI":
                num = 6;
                break;
            case "V":
                num = 5;
                break;
            case "IV":
                num = 4;
                break;
            case "III":
                num = 3;
                break;
            case  "II":
                num = 2;
                break;
            case "I":
                num = 1;
                break;
            default:
                num = 11;
        }


        return num;
    }

    public static boolean isNumeric(String str) { // проверка на число. Тоже подсмотрел в интернете
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}