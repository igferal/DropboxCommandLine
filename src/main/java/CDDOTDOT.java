import com.dropbox.core.DbxException;

/**
 * Created by Ignacio Fernández on 17/09/2016.
 */
public class CDDOTDOT implements Action {


    public boolean run(MainController client) throws DbxException {


        String currentFolder = client.getCurrentFolder();
        String previous = getPreviousFolder(currentFolder.split("/"));
        client.setCurrentFolder(previous);

        return true;

    }

    public String getPreviousFolder(String[] line) {


        String previous = "";
        for (int i = 0; i < line.length - 1; i++) {

            previous += ("/" + line[i]);
        }

        if("/".equals(previous))
            return "";
        return previous;
    }


}
