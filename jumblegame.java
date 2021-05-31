import java.util.Scanner;
import java.util.concurrent.*;

public class jumblegame {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1.Word Game\n2.Jumbel word");
        System.out.println("Enter the game of your choice: \nPress number");
        int i = sc.nextInt();
        switch (i) {
            case 1:
                WordGame();
                break;
            case 2:
                JumbleWord();
                break;
            default:
                System.out.println("Enter valid choice: ");
                break;
        }
    }

    public static void WordGame() {
        String[] a = { "chennai", "Hyderabad", "Thiruputhi", "Basar", "Nirmal","Nizamabad" };
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int j = ThreadLocalRandom.current().nextInt(a.length);
            String original = a[j];
            String org = shuffle(original);
            System.out.println(org);
            System.out.println("Enter answer: ");
            String ans = sc.next();
            if (original.equalsIgnoreCase(ans)) {
                System.out.println("Correct!\n");
                count++;
            } else {
                System.out.println("Wrong!\n");
            }
        }
        System.out.println("Your score: " + count);
    }

    private static String shuffle(String original) {
        int i = original.length();
        char[] origin = original.toCharArray();
        int j = ThreadLocalRandom.current().nextInt(i);
        int k = ThreadLocalRandom.current().nextInt(i);
        int l = ThreadLocalRandom.current().nextInt(i);
        origin[j] = '*';
        origin[k] = '*';
        origin[l] = '*';
        return new String(origin);
    }

    public static void JumbleWord() {
        int count = 0;
        String[] a = {"parrot", "Elephant", "Squirrel", "Chimpanzee","Goldfish","Hamster"};
        for(int m = 0;m<a.length;m++)
        {
            int i = ThreadLocalRandom.current().nextInt(a.length);
            String original = a[i];
            String org = shuffleLetters(original);
            System.out.println(org);
            System.out.println("Enter your answer: ");
            String ans = sc.next();
            if (original.equalsIgnoreCase(ans)) {
                System.out.println("Correct!");
                count = count + 1;
            } else
                System.out.println("Wrong!");
        }System.out.println("total score: "+count);
    }

    private static String shuffleLetters(String original) {
        char[] s= null;
        for (int k = 0; k < 10; k++) {
            int j = ThreadLocalRandom.current().nextInt(original.length());
            int l = ThreadLocalRandom.current().nextInt(original.length());
            s = original.toCharArray();
            char temp =s[j];
            s[j] = s[l];
            s[l] = temp;
        }
        return new String(s);
    }
}
