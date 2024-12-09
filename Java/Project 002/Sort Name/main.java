import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter A Sentence: ");
        String s1;
        s1 = input.nextLine();
        rev(s1);
    }

    public static void rev(String s1) {
        String[] sentence = s1.split(" ");
        String temp, res;
        for (int i = 0; i < sentence.length / 2; i++) {
            temp = sentence[sentence.length - 1 - i];
            sentence[sentence.length - 1 - i] = sentence[i];
            sentence[i] = temp;
        }
        res = String.join(" ", sentence);
        System.out.println(res);
    }
}

//      Mohammad Mahdi Heidari