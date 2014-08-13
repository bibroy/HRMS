/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.RecieptDocumentDAO;
import com.forms.ReimbursmentForm;
import com.pojo.RecieptDocuments;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author sujatas
 */
public class UploadRecieptUtil {

    private static  DAOFactory factory=new DAOFactory();
    
 /*   public void uploadReciept(HttpServletRequest request,ReimbursmentForm reimbursmentForm,String uploadType)throws Exception
    {
        
         //Start upload reciept

             String physicalPath=request.getRealPath("").replace("\\","/");   //print: D:/My_Project/NetB/build/HRMS/web
             physicalPath=physicalPath.replace("build/", "");                 //print: D:/My_Project/NetB/HRMS/web
            String rootDir =physicalPath +"/Reimbursment/";

            String prefixFileName = reimbursmentForm.getEmpId()+ "_"+ Math.random();  //Prefix Create Form Reciept Form
            System.out.println("Prefix file Name====>"+prefixFileName);
             FormFile myReciept = reimbursmentForm.getRecieptCopy();
             System.out.println("Recipt copy===>"+myReciept);
             int byteRead = 0;
            int totalbyteRead = 0;
            int fileSizeReciept = myReciept.getFileSize();
            String fileNameReciept = myReciept.getFileName();
            DataInputStream disReciept = new DataInputStream(myReciept.getInputStream());

            byte dataBytesR[] = new byte[fileSizeReciept];

            byteRead = 0;
            totalbyteRead = 0;
            while (totalbyteRead < fileSizeReciept) {

                byteRead = disReciept.read(dataBytesR, totalbyteRead, fileSizeReciept);
                totalbyteRead += byteRead;

            }//end of while

            String folderReciept = rootDir + "reciept/";
            System.out.println("Folder reciept======>"+folderReciept);

            FileOutputStream fileout = new FileOutputStream(folderReciept + fileNameReciept);

            fileout.write(dataBytesR);

            fileout.flush();
            fileout.close();

            String myRecieptNewName = prefixFileName + ".doc";
            System.out.println("Pojo set name======>"+myRecieptNewName);

            File myRecieptChangeName = new File(rootDir + "reciept/" + fileNameReciept);
            myRecieptChangeName.renameTo(new File(rootDir + "reciept/" + myRecieptChangeName));


            //End upload reciept

        
    }*/

    public static String uploadReciept(HttpServletRequest request,ReimbursmentForm reimbursmentForm,String uploadType)throws Exception{

        FormFile fileDtl=null;
        int fileSize=0;
        String physicalPath = request.getRealPath("").replace("\\", "/");

        System.out.println("@@@ Print physical path @@@"+physicalPath);
        physicalPath = physicalPath.replace("build/", "");
        String rootDir ="";
       // String virtualPath="";
        DataInputStream inpStream=null;
        int byteRead = 0;
        int totalbyteRead = 0;
        FileOutputStream outputStream=null;
        File changeFile=null;


        if(uploadType.equalsIgnoreCase("recieptCopy")){
            System.out.println("Inside If uploadType===recieptCopy");
            fileDtl=reimbursmentForm.getRecieptCopy();
            
            System.out.println("File Detail========>"+reimbursmentForm.getRecieptCopy());

            rootDir = physicalPath + "/Reimbursment/";
            System.out.println("Root Dir=====>"+rootDir);
           // virtualPath="data/trainingmaterials/";
        }

        //System.out.println("Virtual Path======>"+virtualPath);

        String[]filePart= fileDtl.getFileName().split("\\.");
       // System.out.println("File Name====>"+ fileDtl.getFileName());
        
         fileSize=fileDtl.getFileSize();
        
         String prefixFileName=reimbursmentForm.getEmpId()+"_"+reimbursmentForm.getReason()+"_"+fileDtl+"_"+Math.random()+"."+filePart[filePart.length-1];
        //String prefixFileName="xxx";
        System.out.println("Prefix File name=======>"+prefixFileName);
        byte dataByte[]=new byte[fileSize];
        inpStream=new DataInputStream(fileDtl.getInputStream());

        while (totalbyteRead<fileSize) {
           byteRead=inpStream.read(dataByte,totalbyteRead,fileSize);
           totalbyteRead +=byteRead;
           System.out.println("Total Byte read======>"+totalbyteRead);
        }

        outputStream=new FileOutputStream(rootDir+fileDtl.getFileName());
        outputStream.write(dataByte);

        outputStream.flush();
        outputStream.close();

        changeFile=new File(rootDir+fileDtl.getFileName());
        changeFile.renameTo(new File(rootDir+prefixFileName));
        System.out.println("PrefixFileName name=========>"+prefixFileName);

        return (prefixFileName);
    }


     public static boolean addRecieptDoc(RecieptDocuments docDump)throws DAOException,Exception{
        boolean flg=false;
        RecieptDocumentDAO docDumpDao=factory.createRecieptDocumentManager();
        System.out.println("Inside addRecieptDoc=======");
        docDumpDao.addDocDump(docDump);
        flg=true;
        return flg;
    }




}
