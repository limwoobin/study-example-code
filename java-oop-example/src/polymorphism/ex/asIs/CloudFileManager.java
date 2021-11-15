package polymorphism.ex.asIs;

import java.io.File;
import java.util.List;

public class CloudFileManager {
    public List<FileInfo> getFileInfos(CloudId cloudId) {
        if (cloudId == CloudId.DROPBOX) {
//            ...
        } else if (cloudId == CloudId.BOX) {
//            ...
        } else if (cloudId == CloudId.DCLOUD) {
            //            ...
        } else if (cloudId == CloudId.NCLOUD) {
            //            ...
        } else if (cloudId == CloudId.SCLOUD) {
            //            ...
        }

        return null;
    }

    public void download(FileInfo file , File localTarget) {
        if (file.getCloudId() == CloudId.DROPBOX) {
//            ...
        } else if (file.getCloudId() == CloudId.BOX) {
//            ...
        } else if (file.getCloudId() == CloudId.DCLOUD) {
            //            ...
        } else if (file.getCloudId() == CloudId.NCLOUD) {
            //            ...
        } else if (file.getCloudId() == CloudId.SCLOUD) {
            //            ...
        }
    }
}
