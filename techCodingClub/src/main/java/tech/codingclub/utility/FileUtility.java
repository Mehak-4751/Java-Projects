package tech.codingclub.utility;

import java.io.File;

public class FileUtility {

    public static boolean createFile(String filename){
        File file=new File(filename);
        boolean fileCreated=false;
        try{
            fileCreated=file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileCreated;
    }

    public static void main(String[] args) {
        String filepath;
        filepath = "C:\\Users\\hp\\IdeaProjects\\TechCodingMafia\\data\\practice\\file\\createfile.txt";
        boolean status=createFile(filepath);
        System.out.println(status);
    }
}
