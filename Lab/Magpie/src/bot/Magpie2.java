package bot;

import java.io.IOException;
import java.util.Scanner;

public class Magpie2 {

    private Scanner scanner;
    private PhraseRecognizer phraseRecognizer;
    private String statement;

    public Magpie2() {
        scanner = new Scanner(System.in);
        phraseRecognizer = PhraseRecognizer.getPhraseRecognizer();
    }

    public void start() {
        System.out.print("Hello there!"
                + "\n> ");

        do {
            statement = scanner.nextLine()
                    .toLowerCase()
                    .trim();

            if (statement.equals("bye"))
                break;

            clearScreen();
            respond();

            System.out.print("> ");
        } while (true);
    }

    private void respond() {
        if (phraseRecognizer.mentionsAnimalPet(statement))
            System.out.println("Tell me more about your pets");
        else
            System.out.println("I see");
    }

    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {}
    }
}
