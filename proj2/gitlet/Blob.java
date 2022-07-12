package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.*;

public class Blob implements Serializable {

    private final byte[] content;
    private final String id;
    private final File source;

    public Blob(File source) {
        this.content = Utils.readContents(source);
        this.id = Utils.sha1(source.getPath(), this.content);
        this.source = source;
    }

    public File getSource() {
        return source;
    }

    public String getId() {
        return id;
    }

    public byte[] getContent() {
        return content;
    }
}
