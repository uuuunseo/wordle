import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m"; //기본 색
    public static final String ANSI_YELLOW = "\u001B[33m"; // 노란 색
    public static final String ANSI_GREEN = "\u001B[32m"; // 초록 색 
    public static void main(String[] args) {

        System.out.println("Wordle: 다섯 글자 영단어를 입력해 주세요!"); 

        String answerChoosen = ReturnRandomWord(); // 랜덤으로 정답 선정
        char[] answer = new char[5]; // 답을 입력 받는 배열
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerChoosen.charAt(i); //정답과 답이 맞는지 확인
        }

        boolean done = false; // 정답을 맞추기 전이므로 false값을 가짐

        while (!done){
            String R1 = s.nextLine().toLowerCase(); 
            while (R1.length() < 5) { //입력 받은 받의 길이가 5보다 작다면 다시 입력
                R1 = s.nextLine().toLowerCase(); 
            }
        }
        System.out.println("답을 찾았습니다!");
    }
   
    private static String ReturnRandomWord() { // 랜덤으로 한 단어를 반환
        return null;
    }

}