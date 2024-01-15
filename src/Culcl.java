public class Culcl {
    int x;
    int y;

    boolean theRome = false; // чек является ли строка ввода римской или арабской

    String test(String input){ //метод по определению операции
        char[] arr = input.toCharArray();
        String s ="notFound";

        for (char c : arr) {

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

        return s;
    }

    String test2 (String a, String b){// метод выполнения операции и конвертации, если нужно
        int result = 0;
        if ( b.equals("Exit")){
            return "Exit";
        }
        if(a.equals("notFound")){
            return "Вы не ввели знак операции или ввели некоректное значение.";
        }
        String[] numbs = b.split(a);
        if(numbs.length>2){
            return "Вы ввели более 2х знаков выражения";
        }
        if(isNumeric(numbs[0]) && isNumeric(numbs[1])){// чек на арабский или риский ввод
            x = Integer.parseInt(numbs[0]);// перевод строки в  инт
            y = Integer.parseInt(numbs[1]);
        }else {
            x = convertToArab(numbs[0]);// конвертация в арабский для выполнения операции
            y = convertToArab(numbs[1]);
            if (x>10 || y>10){
                return "Вы ввели некоррректное значение";
            }
            theRome= true;
        }
         if(x>0 && x<11 && y>0 && y<11) {

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
             return "Вы ввели слишком большое значение, введите значение от 1 до 10.";
         }
        if(theRome){
            return convertToRome(result);// перевод обратно в риское исчесление, если ввод был на римском и возвращение результата
        }
        return Integer.toString(result); // возвращаем результат

    }

    String convertToRome(int number){// конвертация в римские цифры
        int[] numbs = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] keys = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();

        int x = 0;
        while (x< keys.length){
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

    int convertToArab (String str){ // ковертация в арабские цифры тут все просто
        int num=0;
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

    public static boolean isNumeric(String str) { // проверка на число
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}