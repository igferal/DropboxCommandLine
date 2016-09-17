import com.dropbox.core.DbxException;

/**
 * Created by Ignacio Fernández on 17/09/2016.
 */
public class Executor {


    public void run(Action action, MainController client) {


        try {
            action.run(client);

        } catch (DbxException e) {
            e.printStackTrace();
        }

    }

}
