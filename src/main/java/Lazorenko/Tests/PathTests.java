package Tests;

import java.io.File;
import java.io.IOException;

/**
 * Created by andriylazorenko on 11.07.15.
 */
public class PathTests {
    public static void main(String[] args) throws IOException {
        File file = new File("src/ConfigFiles/File.txt");
        file.createNewFile();
    }
}
