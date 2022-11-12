import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;
import javax.xml.transform.Templates;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class GUI extends JFrame implements ActionListener{
    private static JPanel panel;
    private static JFrame frame;
   
    private static JLabel Title;
    private static JLabel stats;
    private static JTextField userText1;
    private static JLabel[] labels;

    public static Scanner s = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

    static String[] possibleWords;
    static int tries;
    static char[] input;
    static char[] answer;
    static boolean done;
    static String answerChoosen;

    public static void main(String[] args) {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(400, 600); //화면 크기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle("워들워들"); // 제목
        frame.setLocationRelativeTo(null); 
        frame.add(panel); //패널 추가 

        //제목
        panel.setLayout(null);
        Title = new JLabel("Wordle: ");
        Title.setBounds(10, 20, 80, 25 );
        panel.add(Title);

        //단어 입력 설명
        panel.setLayout(null); 
        stats = new JLabel("다섯글자 영단어를 입력해주세요");
        stats.setBounds(10, 50, 180, 25);
        panel.add(stats);

        //단어 색깔 수정
        userText1 = new JTextField();
        userText1.addActionListener(new GUI());
        userText1.setBounds(40, 80 + (0 * 25), 80, 25);
        panel.add(userText1);

        // 다음 줄로 이동
        JButton button = new JButton("Enter");
        button.setBounds(100, 20, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        //글꼴, 색상, 경계 설정
        labels = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            labels[i] = new JLabel("<html><font size = '20' color=blue> ----- </font> <font");
            labels[i].setBounds(44, 80+(i * 25), 80, 25);
            panel.add(labels[i]);
        }

        frame.setVisible(true);

        StartWordle();
    }
    public static void StartWordle() {

        possibleWords = new String[12947];

        try {
            File myObj = new File("wordleWords.txt");
            Scanner myReader = new Scanner(myObj);
            int indexCounter = 0;
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();

                possibleWords[indexCounter] = data;
                indexCounter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("오류가 발생했습니다.");
            e.printStackTrace();
        }

        tries = 0;
        System.out.println("Wordle : 다섯글자 영단어를 입력하세요");
        answerChoosen = ReturnRandomWord();
        answer = new char[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = answerChoosen.charAt(i);
        }

        input = new char[5];
    }

    public static void EndWordle() {
        System.out.println("wordle: 정답은: " + new String(answerChoosen));
        System.out.println("wordle: 시도한 횟수: " + tries);

        userText1.setEnabled(false);
        userText1.setVisible(false);

        if (!done) {
            stats.setText("");
        }
    }

}
