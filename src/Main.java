import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        try (FileReader reader = new FileReader("file1.txt")) {

            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {


                    buf = Arrays.copyOf(buf, c);

                File file = new File("file2.txt");
                file.createNewFile();
                PrintWriter out = new PrintWriter(new FileOutputStream(
                        new File("file2.txt"),
                        true /* append = true */));
                try {
                    out.print(buf);
                } finally {
                    out.close();
                }
            }
        }
    }
}


