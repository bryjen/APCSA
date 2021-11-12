package init;

public class Initializer {
    //region Singleton Methods

    private static Initializer initializer;

    public static void Initialize(String[] args) {
        initializer = new Initializer(args);
        initializer.argumentHandler.parseCommandLineArguments();
    }

    public static Initializer getInitializer() {
        return initializer;
    }

    //endregion

    private final ArgumentHandler argumentHandler;

    boolean isRunningInEditor;

    private Initializer(String[] args) {
        ArgumentHandler.Initialize(args);
        argumentHandler = ArgumentHandler.getArgumentHandler();
    }

    public boolean isRunningInEditor() { return isRunningInEditor; }


}
