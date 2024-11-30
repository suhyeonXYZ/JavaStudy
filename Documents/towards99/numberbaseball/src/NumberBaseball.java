import java.util.*;

public class NumberBaseball {
    public static void main(String[] args) {

        String answer = "123";

        int strike = 0;
        int ball = 0;

        while(!checkAnswer(strike,ball)){

            String input = inputGuess();

            strike = countStrike(answer, input);
            ball = countBalls(answer, input);
            System.out.println(strike + " strike " + ball + " ball 입니다.");
        }

        System.out.println("정답입니다!");

    }


    public static String inputGuess() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("세 자리 정수를 입력하세요:");

        String input = scanner.nextLine();

        while ((!checkInteger(input)) || (input.length() != 3)) { // 정수 형식이 아니거나, 길이가 3이 아닐 때

            System.out.println("잘못된 형식입니다. 세 자리 정수를 입력해주세요:");
            input = scanner.nextLine();
        }

        return input;
    }

    public static boolean checkInteger(String input) {

        try {
            int intInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;

    }


    public static int countStrike(String answer, String input) {

        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                strike++;
            }

        }
        return strike;

    }


    public static int countBalls(String answer, String input) {

        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                balls++;
            }
        }

        return balls;
    }

    public static boolean checkAnswer(int strike, int ball) {

        if(strike != 3){
            return false;
        }else{
            return true;
        }

    }

}