package polymorphism.ex.toBe;

public class CloudFileSystemFactory {
    public static CloudFileSystem getFileSystem(CloudId cloudId) {
        if (cloudId == CloudId.BOX) {
            return new BoxFileSystem();
        } else if (cloudId == CloudId.DROPBOX) {
            return new DropBoxFileSystem();
        }

        return null;
    }
}
