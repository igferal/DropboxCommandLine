import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;

/**
 * Created by Ignacio Fernández on 16/09/2016.
 */
public interface Action {

    boolean run(MainController client) throws DbxException;

}
