package lwh.java.other;

import java.io.File;

/**
 * @author lwh
 * @date 2019-03-01
 * @desp
 */
public class FindAllFiles {

    public static void main(String[] args) {
        String path = "D:\\Software\\IDEA\\Projects\\JavaBase\\src\\lwh\\java";

        File file = new File(path);

        listFiles(file);

        listDir(file);
    }

    private static void listDir(File file) {
        if(file != null && file.isDirectory()){
            System.out.println("我是目录, 目录名是: " + file.getName());
            File[] files = file.listFiles();
            for(File f : files){
                listDir(f);
            }
        }
    }

    private static void listFiles(File file) {
        if(file.isFile()){
            System.out.println("我是文件,文件名: " + file.getName());
        }else {
            System.out.println("我是目录,目录名: " + file.getName());
            File[] files = file.listFiles();
            for(File f : files){
                listFiles(f);
            }
        }
    }
}
