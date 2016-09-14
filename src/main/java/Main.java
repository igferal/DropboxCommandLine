/**
 * Created by Ignacio Fernández on 14/09/2016.
 */
package com.dropbox.core.examples.tutorial;

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

import static java.lang.System.in;

public class Main {
    private static final String ACCESS_TOKEN = "jt0vzkjs7lg3tyv";

    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
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

        // Upload "test.txt" to Dropbox
        try {
            InputStream inn = new FileInputStream("test.txt");
            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
                    .uploadAndFinish(inn);

        }catch (Exception e){
            System.err.print("Mistake");
        }
    }
}

//jt0vzkjs7lg3tyv  APP KEY
//gahytstsyk1z2qj  SECRET KEY
