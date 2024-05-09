import java.util.*;

public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine= sc.nextLine();
        boolean correctInput = (inputLine.matches("-?(1|2|3|4|5|6|7|8|9|10) (\\+|-|\\*|/|) -?(1|2|3|4|5|6|7|8|9|10)") || inputLine.matches("-?(I|II|III|IV|V|VI|VII|VIII|IX|X) (\\+|-|\\*|/|) -?(I|II|III|IV|V|VI|VII|VIII|IX|X)"));
        if (!correctInput){
            throw new RuntimeException("Ввод символов, не подлежащих условию задачи.");
        }

        System.out.println(Calc.calc(inputLine));
    }

    public static String calc(String input) {
        Converter converter = new Converter();
        String[] operands = {"+", "-", "*", "/"};
        String[] arr = input.split(" ");
        String sign = arr[1];

        int result = 0;
        String answer;

        int firstNumber, secondNumber;
        boolean isRoman=converter.isRoman(arr[0]);
        if (isRoman) {
            firstNumber = converter.romanToInt(arr[0]);
            secondNumber = converter.romanToInt(arr[2]);
        } else {
            firstNumber = Integer.parseInt(arr[0]);
            secondNumber = Integer.parseInt(arr[2]);
        }

        switch (sign) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }

        if (isRoman) {
            if (result<1){
                throw new RuntimeException("Результат операции с римскими числами не может быть меньше 1.");
            }
            answer=converter.intToRoman(result);
        }else {
            answer=String.valueOf(result);
        }
        return answer;
    }
}



