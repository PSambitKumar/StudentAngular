package com.csm.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommonFileUpload {
    public static final String windowsRootFolder = "C://UserCreate//";
    public static final String linuxRootFolder = "/opt/UserCreate/";
    public static String operatingSystem = System.getProperty("os.name").toLowerCase().trim();


    public static String createFolder(String folderName){
        String filePath = "";
        String result= null;
        if (operatingSystem.contains("windows")){
            filePath = windowsRootFolder + folderName;
        }
        else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")){
            filePath = linuxRootFolder + folderName;
        }

        File file = new File("C://UserCreate");
        if (!file.exists()){
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y'){
                boolean checkCreated = file.mkdir();
                if (checkCreated){
                    File file1 = new File(filePath);
                    if (!file1.exists()){
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1){
                            result = "Success";
                        }
                        else {
                        }
                    }
                }
            }
            else{
                result = "Failed";
            }
        }
        else{
            File file1 = new File(filePath);
            if (!file1.exists()){
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2){
                    result = "Success";
                }
                else {
                }
            }
        }
        return result;
    }


    public static String fileExistsOrNot(String folderName){
        String filePath = "";
        String result= null;
        if (operatingSystem.contains("windows")){
            filePath = windowsRootFolder + folderName;
        }
        else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")){
            filePath = linuxRootFolder + folderName;
        }

        File file = new File("C://RegistrationData");
        if (!file.exists()){
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y'){
                boolean checkCreated = file.mkdir();
                if (checkCreated){
                    File file1 = new File(filePath);
                    if (!file1.exists()){
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1){
                            result = "Success";
                            return filePath + "//";
                        }
                        else {
                            return filePath + "//";
                        }
                    }
                }
            }
            else{
                result = "Failed";
            }
        }
        else{
            File file1 = new File(filePath);
            if (!file1.exists()){
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2){
                    result = "Success";
                    return filePath + "//";
                }
                else {
                    return filePath + "//";
                }
            }
        }
        return filePath;
    }

    public static String singleFileUplaod(MultipartFile file, String filePath) throws IOException {
        String fileFlag = "";
        if (file.isEmpty()){
        fileFlag = "FileEmpty";
        }
        else {
            String folderPath = fileExistsOrNot(filePath);
            byte[] bytes =file.getBytes();
            Path path =Paths.get(folderPath + "//" + file.getOriginalFilename());
            Files.write(path, bytes);
            fileFlag = folderPath + "//" + file.getOriginalFilename();
        }
        return fileFlag;
    }
}
