import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

/**
 * Created by Ignacio Fernández on 16/09/2016.
 */
public class MainController {

    private static final String ACCESS_TOKEN = "3rAS0cLQp0gAAAAAAAAioY2fVFcoPXyUK9OZMB7eMedylZ_yecYgIDW7RnwNkkeH";

    private DbxClientV2 client;

    private String currentFolder;

    private Executor executor;


    public MainController() {

        this.executor = new Executor();
        this.currentFolder = "";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("DropboxCommandLine").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
        LoggingInfo();
    }


    public void ls() {

        executor.run(new LS(), this);

    }

    public void cd(String currentFolder) {

        executor.run(new CD(currentFolder), this);

    }

    public void cdDotDot() {
        executor.run(new CDDOTDOT(), this);
    }

    public void upload(String file) {
        executor.run(new Upload(file), this);
    }

    public void mkDir(String currentFolder) {
        executor.run(new MkDir(currentFolder), this);
    }

    public void exit() {
        System.exit(0);
    }


    private void LoggingInfo() {
        FullAccount account = null;
        try {
            account = client.users().getCurrentAccount();
            System.out.println("You logged as: " + account.getName().getDisplayName());
            // Get files and folder metadata from Dropbox root directory
        } catch (DbxException e) {
            e.printStackTrace();
        }
    }

    public DbxClientV2 getClient() {
        return client;
    }

    public void setClient(DbxClientV2 client) {
        this.client = client;
    }

    public String getCurrentFolder() {
        return currentFolder;
    }

    public void setCurrentFolder(String currentFolder) {
        this.currentFolder = currentFolder;
    }


}
