package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    List<Character> getUniqueChars(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Text is null.");
        }
        List<Character> result = new ArrayList<>();
        for (Character ch : input.toCharArray()) {
            if (!result.contains(ch)) {
                result.add(ch);
            }
        }
        return result;
    }
}
