package init;

import java.util.ArrayList;
import java.util.Arrays;

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

    private Initializer initializer;

    private ArgumentHandler(String[] args) {
        this.args = args;
        commands = new ArrayList<>();
    }

    public void parseCommandLineArguments() {
        initializer = Initializer.getInitializer();

        splitIntoArrayCommands();
        //printAllCommands(); //todo add this to like a debug mode or something
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
            if (args[i].startsWith("-")) {

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

        ArrayList<String> command = new ArrayList<>();
        for (int i = anchorPoint; i < args.length; i++)
            command.add(args[i]
                    .trim()
                    .toLowerCase()
            );
        commands.add(command.toArray(new String[0]));
    }

    private void executeCommands() throws IllegalArgumentException {
        if (args.length == 0)
            return;

        for (String[] command : commands) {
            switch (command[0].substring(1)) {

                case "em", "editormode", "editor":
                    executeEditorModeCommand(command);
                    break;

                default:
                    throw new IllegalArgumentException(("INVALID COMMAND \"" + command[0] + "\""));
            }
        }
    }

    private void executeEditorModeCommand(String[] command) throws IllegalArgumentException {
        if (command.length != 2)
            throw new IllegalArgumentException(("INVALID ARRAY LENGTH: " + command.length
                    + "\n- The '-editormode' command has only one parameter in the form '-editormode true/false'"));

        if (command[1].equals("true") || command[1].equals("t"))
            initializer.isRunningInEditor = true;
        else if (command[1].equals("false") || command[1].equals("f"))
            initializer.isRunningInEditor = false;
        else
            throw new IllegalArgumentException(("INVALID PARAMETER: '" + command[1] + "'"
                    + "\nBOOLEAN PARAMETER REQUIRED t/true/f/false"));
    }

    private void printAllCommands() {
        for (String[] command : commands) {
            System.out.println(Arrays.toString(command));
        }
    }
}