import com.dropbox.core.DbxException;

/**
 * Created by Ignacio Fernández on 17/09/2016.
 */
public class CD implements Action {

    private String folder;

    public CD(String folder) {

        this.folder = folder;

    }

    public boolean run(MainController client) throws DbxException {


        client.setCurrentFolder(client.getCurrentFolder()+"/"+folder);
        return true;

    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
