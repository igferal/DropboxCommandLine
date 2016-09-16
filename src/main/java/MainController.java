import Actions.Action;
import Actions.LS;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.util.List;

/**
 * Created by Ignacio Fernández on 16/09/2016.
 */
public class MainController {

    private static final String ACCESS_TOKEN = "3rAS0cLQp0gAAAAAAAAioY2fVFcoPXyUK9OZMB7eMedylZ_yecYgIDW7RnwNkkeH";

    private DbxClientV2 client;

    public DbxClientV2 getClient() {
        return client;
    }

    public void setClient(DbxClientV2 client) {
        this.client = client;
    }

    public MainController(){
        DbxRequestConfig config = DbxRequestConfig.newBuilder("DropboxCommandLine").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
        LoggingInfo();
    }


    public void ls(){

         new LS().run(client) ;

    }


    private void LoggingInfo() {
        FullAccount account = null;
        try {
            account = client.users().getCurrentAccount();
            System.out.println("You logged as: " +account.getName().getDisplayName());
            // Get files and folder metadata from Dropbox root directory
        } catch (DbxException e) {
            e.printStackTrace();
        }
    }


}
