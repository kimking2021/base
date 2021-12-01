package priv.kimking.base.jvm.classpath;

import priv.kimking.base.jvm.classpath.impl.CompositeEntry;
import priv.kimking.base.jvm.classpath.impl.DirEntry;
import priv.kimking.base.jvm.classpath.impl.WildcardEntry;
import priv.kimking.base.jvm.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *
 * @author kim
 * @date 2021/11/23
 */
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {

        //File.pathSeparator；路径分隔符(win\linux)
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }

}
