import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;

/**
 * Created by Ignacio Fernández on 17/09/2016.
 */
public class MkDir implements Action {

    private String folder;


    public MkDir(String folder) {

        this.folder = folder;

    }

    public boolean run(MainController mainController) throws DbxException {


        DbxClientV2 client = mainController.getClient();
        client.files().createFolder("/" + folder);
        return false;

    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
