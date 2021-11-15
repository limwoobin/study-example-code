package polymorphism.ex.toBe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class CloudFileManager {
    public List<CloudFile> getFileInfos(CloudId cloudId) {
        CloudFileSystem fileSystem = CloudFileSystemFactory.getFileSystem(cloudId);
        return fileSystem.getFiles();
    }

    public void download(CloudFile file , File localTarget) throws FileNotFoundException {
        file.write(new FileOutputStream(localTarget));
    }
}
