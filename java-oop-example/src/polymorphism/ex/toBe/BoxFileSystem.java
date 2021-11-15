package polymorphism.ex.toBe;

import java.util.List;

public class BoxFileSystem implements CloudFileSystem {
    @Override
    public List<CloudFile> getFiles() {
        return null;
    }

    @Override
    public List<CloudFile> getFileInfos(CloudId cloudId) {
        return null;
    }
}
