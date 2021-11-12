package bot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhraseRecognizer {

    private static PhraseRecognizer phraseRecognizer;

    public static PhraseRecognizer getPhraseRecognizer() {
        if (phraseRecognizer == null)
            phraseRecognizer = new PhraseRecognizer();

        return phraseRecognizer;
    }

    /** @return returns true if the following animals are mentioned */
    public boolean mentionsAnimalPet(String statement) {
        String[] matchablePets = new String[] {
                "cat", "dog", "bird", "parrot", "hamster", "capybara", "raccoon", "mouse"
        };

        StringBuilder regexBuilder = new StringBuilder();
        for (String pet : matchablePets)
            regexBuilder.append("(" + pet + ")|");

        return statement.matches(".*(" + regexBuilder.substring(0, regexBuilder.length() - 1) + ").*");
    }

}


