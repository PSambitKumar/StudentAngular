package com.sambit.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CommonFileUpload {
    public static final Logger logger = LoggerFactory.getLogger(CommonFileUpload.class);
    public static final String windowsRootFolder = "C://RegistrationData//";
    public static final String linuxRootFolder = "/opt/RegistrationData/";
    public static String operatingSystem = System.getProperty("os.name").toLowerCase().trim();


//    Color
    public static final String ansiGreen = "\u001b[32;1m";
    public static final String ansiRed = "\u001b[31;1m";
    public static final String ansiReset = "\u001B[0m";



//    Create Root Directory and Folder Method
    public static String createFolder(String folderName){
        String filePath = "";
        String newFilePath = "";
        String result= null;
        System.out.println("Logger" + logger.toString() +  "Name: " +  logger.getName());
        System.out.println("Operating System--------------> " + ansiGreen + operatingSystem + ansiReset);
        System.out.println("System Properties--------------> " + ansiGreen + System.getProperties() + ansiReset);
//        operatingSystem.indexOf("windows") >= 0 Instead of  operatingSystem.contains("windows")----------can Used but Not Appropriate

        if (operatingSystem.contains("windows")){
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + " Windows" + ansiReset);
            filePath = windowsRootFolder + folderName;
        }
        else if (operatingSystem.contains("nix") || operatingSystem.contains("nux") || operatingSystem.contains("aix")){
            logger.info("This is " + ansiGreen + System.getProperty("user.name") + "Linux" + ansiReset);
            filePath = linuxRootFolder + folderName;
        }

        //Checking Root Directory is Present or Not
        File file = new File("C://RegistrationData");
        if (!file.exists()){
            logger.info("Root Directory Not Present, Do You Want to Create Root Directory(" + ansiGreen + "Y" + ansiReset + "/" + ansiRed + "N" +ansiReset + ")?!");
            Scanner scanner = new Scanner(System.in);
            char response = scanner.next().charAt(0);
            if (Character.toUpperCase(response) == 'Y'){
                logger.info("Root Directory is Creating....");
                boolean checkCreated = file.mkdir();
                if (checkCreated){
                    logger.info(ansiGreen + "Root Directory Created Successfully." + ansiReset);
                    File file1 = new File(filePath);
                    if (!file1.exists()){
                        logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                        boolean checkCreated1 = file1.mkdir();
                        if (checkCreated1){
                            logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                            newFilePath = filePath + "//";
                            result = "Success";
                        }
                        else {
                            logger.info(folderName + ansiReset + " Already Present in Root Directory!" + ansiReset);
                            newFilePath = filePath + "//";
                        }
                    }
                }
            }
            else{
                logger.info(ansiRed + "Reverting Back!!" + ansiReset);
                result = "Failed";
            }
        }
        else{
            logger.info("Root Directory Present");
            File file1 = new File(filePath);
            if (!file1.exists()){
                logger.info("Creating " + folderName + " Folder Inside Root Directory......");
                boolean checkCreated2 = file1.mkdir();
                if (checkCreated2){
                    logger.info(folderName + ansiGreen + " Created Successfully." + ansiReset);
                    newFilePath = filePath + "//";
                    result = "Success";
                }
                else
                    logger.info(ansiRed + "Error in Creating Folder!" + ansiReset);
            }
            else {
                logger.info(folderName + ansiGreen + " Folder Already Present in Root Directory!" + ansiReset);
                newFilePath = filePath + "//";
            }
        }
        return newFilePath;
    }



//    Single File Upload Method
    public static String singleFIleUpload(MultipartFile file, String folderPath){
        String result = "";
        if (file.isEmpty()){
            result = "Empty File";
        }
        else {
            try {
                String path = createFolder(folderPath.trim());    //This Will Check Folder is Present Or Not, If Present It Message will Display else Folder will be Created.
                logger.info(path);
                byte[] bytes = file.getBytes();
                Path path1 = Paths.get(path+file.getOriginalFilename());
                Files.write(path1, bytes);
                result = folderPath.trim() + "/" +file.getOriginalFilename();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
