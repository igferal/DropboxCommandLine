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
            if ("ls".equals(line)) ;
                mainController.ls();


        }
        while (true);
    }

}
