package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OwlCounter {
    private List<String> owls;

    public void readFromFile(Path path) {
        try {
            owls = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public int getNumberOfOwls(String county) {
        for (String line: owls) {
            String[] parts = line.split("=");
            if (parts[0].equals(county)) {
                return Integer.parseInt(parts[1].trim());
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        int result = 0;
        for (String line: owls) {
            String[] parts = line.split("=");
            result += Integer.parseInt(parts[1].trim());
        }
        return result;
    }
}
