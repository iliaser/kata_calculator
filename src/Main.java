import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) throws Exception {
        String[] expressionArr = input.split(" ");
        String num1 = expressionArr[0];
        String operator = expressionArr[1];
        String num2 = expressionArr[2];

        if (expressionArr.length != 3  || (!isArab(num1) && !isRoman(num1)) || (!isArab(num2) && !isRoman(num2)) || (isArab(num1) && !isArab(num2)) || (!isArab(num1) && isArab(num2)) || !isOperator(operator)) {
            throw new Exception();
        }

        if (isArab(num1)) {
            return String.valueOf(calculate(num1, operator, num2));
        } else {
            if (calculate(num1, operator, num2) <= 0) {
                throw new Exception();
            }
            return toRoman(calculate(num1, operator, num2));
        }
    }

    public static boolean isArab(String input) {
        String[] arabNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String arabNum : arabNums) {
            if (input.equals(arabNum)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRoman(String input) {
        String[] romanNums = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String romanNum : romanNums) {
            if (input.equals(romanNum)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperator(String input) {
        String[] operators = {"+", "-", "*", "/"};
        for (String operator : operators) {
            if (input.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static int toInt(String input) {
        String[] arabNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanNums = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        int num = 1;

        if (isArab(input)) {
            for (String i: arabNums) {
                if (input.equals(i)) {
                    break;
                }
                num++;
            }
        }

        if (isRoman(input)) {
            for (String i: romanNums) {
                if (input.equals(i)) {
                    break;
                }
                num++;
            }
        }

        return num;
    }

    public static int calculate(String num1, String operator, String num2) {
        int result = 0;
        switch (operator) {
            case "+" :
                result = toInt(num1) + toInt(num2);
                break;
            case "-" :
                result = toInt(num1) - toInt(num2);
                break;
            case "*" :
                result = toInt(num1) * toInt(num2);
                break;
            case "/" :
                result = toInt(num1) / toInt(num2);
        }
    return result;
    }

    public static String toRoman(int i) {
        String romanNum = "";
        while (i > 0) {
            if (i == 100) {
                romanNum += "C";
                break;
            }
            if (i >= 90) {
                romanNum += "XC";
                i -= 90;
            } else if (i >= 50) {
                romanNum += "L";
                i -= 50;
            } else if (i >= 40) {
                romanNum += "XL";
                i -= 40;
            } else if (i >= 10) {
                romanNum += "X";
                i -= 10;
            } else if (i >= 9) {
                romanNum += "IX";
                i -= 9;
            } else if (i >= 5) {
                romanNum += "V";
                i -= 5;
            } else if (i >= 4) {
                romanNum += "IV";
                i -= 4;
            } else {
                romanNum += "I";
                i -= 1;
            }
        }
        return romanNum;
    }
}