package Actions;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

/**
 * Created by Ignacio Fernández on 16/09/2016.
 */
public class LS implements Action {


    public boolean run(DbxClientV2 client) {

        try {
            ListFolderResult result = client.files().listFolder("");
            while (true) {
                for (Metadata metadata : result.getEntries()) {
                    System.out.println(metadata.getPathLower());
                }

                if (!result.getHasMore()) {
                    break;
                }

                result = client.files().listFolderContinue(result.getCursor());
            }

        } catch (DbxException e) {
            e.printStackTrace();
        }
        return false;
    }
}

