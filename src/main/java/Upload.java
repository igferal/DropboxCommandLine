import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ignacio Fernández on 17/09/2016.
 */
public class Upload implements Action{

    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Upload(String file){

        this.file=file;

    }

    public boolean run(MainController client) throws DbxException {

        InputStream inn = null;
        try {
            inn = new FileInputStream(file);
            FileMetadata metadata = client.getClient().files().uploadBuilder("/test.txt").uploadAndFinish(inn);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;

    }
}
