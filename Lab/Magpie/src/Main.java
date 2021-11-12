import bot.Magpie2;
import init.Initializer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Initializer.Initialize(args);
        Initializer initializer = Initializer.getInitializer();

        if (initializer.isRunningInEditor()) {
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd.exe /c cd \""
                    +"C:\\Users\\Game\\Documents\\GitHub\\APCSA\\Lab\\Magpie\\out\\production\\Magpie"
                    +"\" & start cmd.exe /k \"java Main\"");

            System.out.println("Launced in cmd terminal");

            //todo put like guide/diagnostics/something else yaknow

            return;
        }

        new Magpie2();
    }


    /*
    OPEN CMD AND RUN THIS PROJECT

    Runtime rt = Runtime.getRuntime();
        rt.exec("cmd.exe /c cd \""
                +"C:\\Users\\Game\\Documents\\GitHub\\APCSA\\Lab\\Magpie\\out\\production\\Magpie"
                +"\" & start cmd.exe /k \"java Main\"");
     */

    /*
    clear console

    System.out.print("\033[H\033[2J");
        System.out.flush();
     */
}
