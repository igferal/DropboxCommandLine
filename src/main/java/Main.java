import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.util.List;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Main {


    public static void main(String args[]) throws IOException {


        UI ui = new UI();

        ui.run();

    }
}
//jt0vzkjs7lg3tyv  APP KEY
//gahytstsyk1z2qj  SECRET KEY
// 3rAS0cLQp0gAAAAAAAAioY2fVFcoPXyUK9OZMB7eMedylZ_yecYgIDW7RnwNkkeH TOKEN