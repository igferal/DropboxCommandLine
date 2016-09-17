import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ignacio Fernández on 16/09/2016.
 */
public class UI {

    private static BufferedReader in;
    private MainController mainController;

    public UI() {

        mainController = new MainController();
    }


    public void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("For help type help");


        do {
            System.out.print("> ");

            String[] line = in.readLine().split(" ");
            String command = line[0];

            if ("ls".equals(command))
                mainController.ls();
            else if ("cd".equals(command) && "..".equals(line[1])) {
                mainController.cdDotDot();
            } else if ("cd".equals(command))
                mainController.cd(fullFolder(line));
            else if ("upload".equals(command))
                mainController.upload(fullFolder(line));
            else if ("exit".equals(command))
                mainController.exit();


        }
        while (true);
    }

    public String fullFolder(String[] line) {


        String folder = "";

        for (int i = 1; i < line.length; i++) {
            if (i == 1) {
                folder += line[i];
            } else {
                folder = folder + " " + line[i];
            }
        }

        return folder;
    }

}
