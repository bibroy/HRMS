/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.ByteArrayOutputStream;
import com.forms.EmployeePersonalInfoForm;
import java.sql.Blob;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import com.forms.RecruitmentForm;
import com.pojo.Recruitment;
import org.hibernate.Session;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import javax.servlet.jsp.tagext.TryCatchFinally;
import org.apache.struts.upload.FormFile;
import com.dao.BaseDAO;
import com.dao.DAOException;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Sumit Kumar
 */
public class ImageUtil implements Serializable {

    public ImageUtil() {
    }


    private byte[] toByteArrayImpl(Blob fromBlob, ByteArrayOutputStream baos)
            throws SQLException, IOException {
        byte[] buf = new byte[4000];
        InputStream is=null;
        try {
             is= fromBlob.getBinaryStream();
            for (;;) {
                int dataSize = is.read(buf);
                if (dataSize == -1) {
                    break;
                }
                baos.write(buf, 0, dataSize);
            }
        }
        catch(Exception e){
            System.out.println("error fetching images "+e.getMessage());
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }

        return baos.toByteArray();
    }

    public byte[] toByteArray(Blob fromBlob) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            return toByteArrayImpl(fromBlob, baos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(baos!=null)
            {
                try {
                    baos.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static byte[] UploadImage(HttpServletRequest request, RecruitmentForm recForm){
        
        FormFile fileDtl=null;
        int fileSize=0;
        DataInputStream inpStream=null;
        int byteRead=0;
        int totalByteRead=0;
        FileOutputStream outputStream=null;
        File changeFile=null;

        fileDtl=recForm.getImageFile();

        fileSize=fileDtl.getFileSize();

        byte dataByte[]=new byte[fileSize];

        try {
            inpStream=new DataInputStream(fileDtl.getInputStream());

            while(totalByteRead<fileSize)
            {
                byteRead=inpStream.read(dataByte,totalByteRead,fileSize);
                totalByteRead+=byteRead;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return dataByte;

    }

public byte[] getPhoto(Integer id)throws DAOException{
        byte[] imgData=null;
        Session session=null;
        Recruitment rec=null;
        List list=null;
        BaseDAO b=new BaseDAO();
        try {
            session=b.getSession();
            session.beginTransaction();
            list=session.createQuery("from Recruitment r where r.id="+id.toString()).list();
            if(list!=null)
            {
                rec=(Recruitment)list.get(0);
            }
            session.getTransaction().commit();
        }  catch (Exception e) {
            session.getTransaction().rollback();
            
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        imgData=rec.getCanImage();
        return imgData;
    }
 public static byte[] UploadImage(HttpServletRequest request, EmployeePersonalInfoForm frm){

        FormFile fileDtl=null;
        int fileSize=0;
        DataInputStream inpStream=null;
        int byteRead=0;
        int totalByteRead=0;
        FileOutputStream outputStream=null;
        File changeFile=null;

        fileDtl=frm.getImageFile();

        fileSize=fileDtl.getFileSize();

        byte dataByte[]=new byte[fileSize];

        try {
            inpStream=new DataInputStream(fileDtl.getInputStream());

            while(totalByteRead<fileSize)
            {
                byteRead=inpStream.read(dataByte,totalByteRead,fileSize);
                totalByteRead+=byteRead;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return dataByte;

    }






}
