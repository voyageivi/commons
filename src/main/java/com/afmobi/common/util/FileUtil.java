// TOP SECRET
package com.afmobi.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author vincent
 * @version 2012-6-1 下午8:27:00
 */
public class FileUtil {

    private static final Logger logger = Logger.getLogger(FileUtil.class);

    public static String join(String... cates) {
        StringBuilder sb = new StringBuilder();
        for (String c : cates) {
            sb.append(File.separator).append(c);
        }
        return sb.toString().substring(1);
    }

    public static int copy(InputStream in, OutputStream out) throws IOException {
        try {
            int byteCount = 0;
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            out.flush();
            return byteCount;
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }

    public static int copy(InputStream inputStream, File file) {
        if (file == null) {
            return -1;
        }
        FileOutputStream fos;
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try {
            fos = new FileOutputStream(file);
            return copy(inputStream, fos);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return -1;
    }

    public static String getWebClassesPath() {
        String path = FileUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return path;

    }

    public static String getWebInfPath() throws IllegalAccessException {
        String path = getWebClassesPath();
        if (path.indexOf("WEB-INF") > 0) {
            path = path.substring(0, path.indexOf("WEB-INF") + 8);
        } else {
            throw new IllegalAccessException("路径获取错误");
        }
        return path;
    }

    public static String getWebRoot() throws IllegalAccessException {
        String path = getWebClassesPath();
        if (path.indexOf("WEB-INF") > 0) {
            path = path.substring(0, path.indexOf("WEB-INF/classes"));
        } else {
            // throw new IllegalAccessException("路径获取错误");
        }
        return path;
    }

    public static String addFilenameExt(String filename, String ext) {
        int index = filename.lastIndexOf(".");
        if (index > 0) {
            return new StringBuffer(filename).insert(index, ext).toString();
        } else {
            return filename + ext;
        }
    }

    public static String getExt(URL url) {
        File f = new File(url.getFile());
        String filename = f.getName();
        int index = filename.lastIndexOf(".");
        return filename.substring(index + 1);
    }

    public static String getExt(String filename) {
        if (!StringUtil.hasLength(filename)) {
            return "";
        }
        int index = filename.lastIndexOf(".");
        if (filename.length() > index + 1) {
            return filename.substring(index + 1);
        } else {
            return "";
        }
    }

    public static String trimExt(String filename) {
        if (filename == null) {
            return "";
        }
        int index = filename.lastIndexOf(".");
        if (index > 0) {
            return filename.substring(0, index);
        } else {
            return filename;
        }
    }

    public static boolean deleteFile(File file) {
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static boolean deleteFile(String filename) {
        File f = new File(filename);
        return deleteFile(f);
    }

    public static void saveClose(Reader br) {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            br = null;
        }
    }

    public static void saveClose(Writer wr) {
        if (wr != null) {
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            wr = null;
        }
    }

    public static String readStream(InputStream stream) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(stream));
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }

        } catch (IOException e) {
        } finally {
            saveClose(br);
        }
        return sb.toString();
    }
    public static String read(File file) {
        try {
            return readStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return null;
        }

    }

    public static boolean write(File file, String content) {
        BufferedWriter bw = null;
        boolean rtn = true;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(content);
        } catch (Exception e) {
            rtn = false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return rtn;
    }

    public static void createFolder(File floder) {
        if (!floder.exists()) {
            floder.mkdirs();
        }
    }

    private static BufferedReader exec(String cmd) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", cmd });
        p.waitFor();
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    /**
     * @return
     */
    public static long getUsedInRoot() {
        long rtn = 0;
        BufferedReader br = null;
        try {
            String cmd = "df|awk '{if($NF==\"/\"){print $(NF-3)}}'";

            br = exec(cmd);
            String line = br.readLine();
            if (null != line && !"".equals(line.trim())) {
                rtn = Long.parseLong(line);
            } else {
                logger.warn("Cannot get root used space.");
            }
        } catch (Exception e) {
            logger.error("get root used space exception happened:" + e.getMessage(), e);
        } finally {
            saveClose(br);
        }
        return rtn;
    }

    public static Set<String> mountedDir() {
        Set<String> rtn = new HashSet<String>();
        BufferedReader br = null;
        try {
            String cmd = "mount|awk '{if($2==\"on\"){print $3}}'";
            br = exec(cmd);
            String line;
            while ((line = br.readLine()) != null) {
                rtn.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            saveClose(br);
        }
        return rtn;
    }

}
