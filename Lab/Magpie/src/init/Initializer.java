package init;

public class Initializer {
    //region Singleton Methods

    private static Initializer initializer;

    public static void Initialize(String[] args) {
        initializer = new Initializer(args);
    }

    public static Initializer getInitializer() {
        return initializer;
    }

    //endregion

    private final String[] args;
    private final ArgumentHandler argumentHandler;

    boolean isRunningInEditor;

    private Initializer(String[] args) {
        this.args = args;

        ArgumentHandler.Initialize(args);
        argumentHandler = ArgumentHandler.getArgumentHandler();
    }


}
