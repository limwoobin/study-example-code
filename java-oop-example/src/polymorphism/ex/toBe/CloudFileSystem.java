package polymorphism.ex.toBe;

import java.util.List;

public interface CloudFileSystem {
    List<CloudFile> getFiles();
    List<CloudFile> getFileInfos(CloudId cloudId);
}
