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

        panel.setLayout(null);
        Title = new JLabel("Wordle: ");
        Title.setBounds(10, 20, 80, 25 );
        panel.add(Title);

        panel.setLayout(null);
        stats = new JLabel("다섯글자 영단어를 입력해주세요");
        stats.setBounds(10, 50, 180, 25);
        panel.add(stats);

        userText1 = new JTextField();
        userText1.addActionListener(new GUI());
        userText1.setBounds(40, 80 + (0 * 25), 80, 25);
        panel.add(userText1);

        JButton button = new JButton("Enter");
        button.setBounds(100, 20, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        
    }

}
