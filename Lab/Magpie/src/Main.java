import init.Initializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Initializer.Initialize(args);
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
