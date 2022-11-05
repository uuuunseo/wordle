import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m"; //기본 색
    public static final String ANSI_YELLOW = "\u001B[33m"; // 노란 색
    public static final String ANSI_GREEN = "\u001B[32m"; // 초록 색 
    public static void main(String[] args) {
        int tries = 0; // 시도 횟수

        System.out.println("Wordle: 다섯 글자 영단어를 입력해 주세요!"); 

        String answerChoosen = ReturnRandomWord(); // 랜덤으로 정답 선정
        char[] answer = new char[5]; // 정답을 넣는 배열
        
        for (int i = 0; i < answer.length; i++) { // 랜덤으로 선정된 정답을 정답 배열에 넣기
            answer[i] = answerChoosen.charAt(i); 
        }

        boolean done = false; // 정답을 맞추기 전이므로 false값을 가짐
        char [] input = new char[5]; // 입력 받은 답을 넣는 배열

        while (!done){
            tries++; //시도 횟수 증가
            String R1 = s.nextLine().toLowerCase(); // 답 입력 받기
            while (R1.length() < 5) { //입력 받은 답의 길이가 5보다 작다면 다시 입력
                R1 = s.nextLine().toLowerCase();
            }
            for(int i = 0; i < 5; i++ ) { //입력 받은 답을 배열에 넣기
                answer[i] = answerChoosen.charAt(i);
                input[i] = R1.charAt(i);
            }
            if(PrintWordWithColor(input, answer)) { //PrintWordWhitColor가 ture 값을 주면 done = true
                done = true;
            }
        }
        System.out.println(tries + "번 만에 답을 찾았습니다!"); // done이 true가 되었으므로 답을 찾았습니다 출력
    }
   
    public static boolean PrintWordWhitColor(char[] inputWord, char[] correctWord) { 
        boolean correct = true;
        char[] answerTemp = correctWord; // 
        int[] colorForLetter = new int[5]; // 문자별로 색깔을 달리 하기 위한 배열
    }

    private static String ReturnRandomWord() { // 랜덤으로 한 단어를 반환
        return null;
    }

    

}