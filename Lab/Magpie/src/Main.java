import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Magpie2 magpie = new Magpie2();

        System.out.println(magpie.getGreeting());
        String statement = scanner.nextLine()
                .toLowerCase();

        while (statement.equals("bye")) {
            System.out.println(magpie.getResponse(statement));
            statement = scanner.nextLine()
                    .toLowerCase();
        }
    }
}
