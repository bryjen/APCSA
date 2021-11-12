package init;

import javax.management.monitor.CounterMonitorMBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ArgumentHandler {
    //region Singleton Methods

    private static ArgumentHandler argumentHandler;

    public static void Initialize(String[] args) {
        argumentHandler = new ArgumentHandler(args);
    }

    public static ArgumentHandler getArgumentHandler() {
        return argumentHandler;
    }

    //endregion

    private final String[] args;
    private final ArrayList<String[]> commands;

    private ArgumentHandler(String[] args) {
        Initializer initializer = Initializer.getInitializer();
        this.args = args;
        commands = new ArrayList<>();

        splitIntoArrayCommands();
        printAllCommands();
        executeCommands();
    }

    /** Splits args into an arraylist of string arrays that start with the keyword '-'
     *  Ex:
     *  ["-command1", "param1", "-command2", "param2", "param3", "-command3", "param4"]
     *  =>
     *  [["-command1", "param1"],
     *  ["-command2", "param2", "param3"],
     *  ["-command3", "param4"]]
     */
    private void splitIntoArrayCommands() {
        int anchorPoint = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-") || i == args.length - 1) {

                //gets the last element of the array
                if (i == args.length - 1)
                    i++;

                if (i != anchorPoint) {
                    ArrayList<String> command = new ArrayList<>();

                    for (int j = anchorPoint; j < i; j++)
                        command.add(args[j]
                            .trim()
                            .toLowerCase()
                        );

                    commands.add(command.toArray(new String[0]));
                }

                anchorPoint = i;
            }
        }
    }

    private void executeCommands() throws IllegalArgumentException {
        for (String[] command : commands) {
            switch (command[0].substring(1)) {
                case "em", "editormode", "editor":
                    //something
                    break;
                default:
                    throw new IllegalArgumentException(("INVALID COMMAND " + command[0]));
            }
        }
    }

    private void printAllCommands() {
        for (String[] command : commands) {
            System.out.println(Arrays.toString(command));
        }
    }
}