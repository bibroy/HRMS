/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;


import com.dao.DAOException;
import com.dao.DAOFactory;
//import com.dao.MannualAttendanceDAO;
//import com.dao.SalaryBreakUpDAO;
//import com.dao.SalaryDAO;
//import com.dao.SalaryHeaderDAO;
//import com.forms.SalaryComputationForm;
//import com.pojo.EmpDetails;
//import com.pojo.SalaryBreakUp;
//import com.pojo.SalaryComputation;
//import com.pojo.SalaryHeader;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;





/**
 *
 * @author dolad
 */
public class UtilityClass implements java.io.Serializable {
        /* public double checkOnHeader(int headerId) throws Exception{
        DAOFactory factory = new DAOFactory();
        SalaryHeaderDAO dao = factory.createSalaryHeaderManager();
        SalaryHeader salary = null;
        String fixOrPer = null;
        double amt = 0.0;

        try{

            salary = dao.getSalaryHeader(headerId);
            fixOrPer = salary.getFixOrPer();

            if(fixOrPer.equals("P")){
               int headOn = salary.getPerOnheader();
               double percentage = salary.getPercentage();

               amt = calculation(headOn, percentage);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return amt;
    }*/


    //This method calculate Amount of Allowance which is percentage of someother salaryHeader
   /* public double calculation(int headerId,double percent) throws Exception{
        DAOFactory factory = new DAOFactory();
        SalaryBreakUpDAO dao = factory.createSalaryBreakUpManager();
       // List<SalaryBreakUp> breakup = null;
        SalaryBreakUp salary = null;
        double amount =0.0;
        int empId = 0;//It is now hardCoded

        try{

            salary = dao.getBreakUp(headerId,empId);

            if(salary!=null ){


                amount =( salary.getAmount() * percent) / 100 ;
            }

            System.out.println("the value of amount====="+amount);

        }catch(Exception e){
            e.printStackTrace();
        }
        return amount;
    }*/
/* This method takes in an image as a byte array (currently supports GIF, JPG, PNG and possibly other formats) and
     * resizes it to have a width no greater than the pMaxWidth parameter in pixels. It converts the image to a standard
     * quality JPG and returns the byte array of that JPG image.
     *
     * @param pImageData
     *                the image data.
     * @param pMaxWidth
     *                the max width in pixels, 0 means do not scale.
     * @return the resized JPG image.
     * @throws IOException
     *                 if the iamge could not be manipulated correctly.
     */
    public static byte[] resizeImageAsJPG(byte[] pImageData, int pMaxWidth) throws IOException {
	// Create an ImageIcon from the image data
	ImageIcon imageIcon = new ImageIcon(pImageData);
	int width = imageIcon.getIconWidth();
	int height = imageIcon.getIconHeight();

	// If the image is larger than the max width, we need to resize it
	if (pMaxWidth > 0 && width > pMaxWidth) {
	    // Determine the shrink ratio
	    double ratio = (double) pMaxWidth / imageIcon.getIconWidth();

	    height = (int) (imageIcon.getIconHeight() * ratio);
	    width = pMaxWidth;

	}
	// Create a new empty image buffer to "draw" the resized image into
	BufferedImage bufferedResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	// Create a Graphics object to do the "drawing"
	Graphics2D g2d = bufferedResizedImage.createGraphics();
	g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	// Draw the resized image
	g2d.drawImage(imageIcon.getImage(), 0, 0, width, height, null);
	g2d.dispose();
	// Now our buffered image is ready
	// Encode it as a JPEG
	ByteArrayOutputStream encoderOutputStream = new ByteArrayOutputStream();
	//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(encoderOutputStream);//bibhash
	//encoder.encode(bufferedResizedImage);//bibhash
	byte[] resizedImageByteArray = encoderOutputStream.toByteArray();
	return resizedImageByteArray;
    }
//This method calculate monthly salary based on attendaence
/*public static List salaryCalculation(SalaryComputationForm salaryform) throws IOException, DAOException {

    List out_emp_list = new ArrayList();
    List in_emp_list = new ArrayList();
    String [] selected_employees = salaryform.getSelected_employee();
    List<EmpDetails> employee_list = null;
    DAOFactory factory = new DAOFactory();
    SalaryBreakUpDAO  salarybreakUp = factory.createSalaryBreakUpManager();
    MannualAttendanceDAO attendancedao = factory.createMannualAttendanceManager();
    SalaryDAO salarydao  = factory.createSalaryManager();

    List<EmployeeUtil> employee = null;
    try{

        int month = salaryform.getMonth();
        int year = salaryform.getYear();
        GregorianCalendar current = new GregorianCalendar(year,month ,0);
        int dayInMonth = current.getActualMaximum(Calendar.DAY_OF_MONTH);

        double presence_percentage;
        employee_list = attendancedao.getAllEmployeeOfCompany(salaryform.getCompanyId());
        int length = (selected_employees == null) ? 0 : selected_employees.length;
        String[] employees = new String[length];
                        for(int cnt = 0 ; cnt<employee_list.size();cnt++){
                            in_emp_list.add(employee_list.get(cnt).getEmployeeId());
                        }

			int indx = 0;
			for(indx = 0; selected_employees != null && indx < selected_employees.length; indx++) {
				employees[indx] = selected_employees[indx];
				out_emp_list.add(selected_employees[indx]);
			}

			for(int i=0;i<in_emp_list.size();i++){
				for(int j=0;j<out_emp_list.size();j++){
					if(in_emp_list.get(i).toString().equals(out_emp_list.get(j).toString())){

						in_emp_list.remove(i);

					}

				}
			}

			String in_employee_set = "";
			for(int i = 0; i < in_emp_list.size(); i++) {
				in_employee_set += (i == in_emp_list.size()-1) ? in_emp_list.get(i) + ") " : in_emp_list.get(i) + ",";
			}
                       employee = salarydao.getEmployeeInfo(in_employee_set);

                       Map attendenceMap = attendancedao.getAllAttendance(year,month, in_employee_set);
                       for(int itr =0;itr<employee.size();itr++){
                            EmployeeUtil empUtil = employee.get(itr);
                            Integer empId = empUtil.getEmployeeId();
                            empUtil.setDay(Integer.parseInt(attendenceMap.get(empId).toString()));

                            presence_percentage = (Double.parseDouble(attendenceMap.get(empId).toString())/dayInMonth);

                            for(int salbreak = 0;salbreak < salarybreakUp.getBreakUp(empId).size();salbreak++){
                                SalaryBreakUp salaryBreakPojo = salarybreakUp.getBreakUp(empId).get(salbreak);
                                SalaryComputation computesalary = new SalaryComputation();

                                computesalary.setEmpId(empId);
                                System.out.println("breakup"+salaryBreakPojo.getAmount());
                                computesalary.setAmount(salaryBreakPojo.getAmount()*presence_percentage);
                                computesalary.setEntryBy(0);
                                computesalary.setEntryDate(new java.util.Date());
                                computesalary.setMonth(month);
                                computesalary.setYear(year);
                                computesalary.setSalaryheadId(Integer.parseInt(salaryBreakPojo.getHeaderId()));
                                computesalary.setStatus("G");
                               // salarydao.save(computesalary);

                            }
                       }




    }catch(Exception e){
        e.printStackTrace();
    }
        return employee;
 }*/
    public    String OraclescreenDateFormatToScreen(String screenDate) {
		try {
//System.out.print("************Date***************    "+screenDate);
                    String date=screenDate.split(" ")[0];
                     date=date.replaceAll("-", "/");
System.out.print("OraclescreenDateFormat    "+date);

			if(screenDate!=null && !screenDate.trim().equals("") ) {
				SimpleDateFormat oldformat=new SimpleDateFormat("yyyy/MM/dd");
				SimpleDateFormat newformat=new SimpleDateFormat("dd/MM/yyyy");

                               Date dt = oldformat.parse(date);


				return newformat.format(dt).toString();
			}
		}catch(Exception e) {
			System.out.print("failed to convert db date to screen date");
		}
		return screenDate.toString();
	}



    public    String [] OraclescreenDateFormatToScreenArray(String screenDate []) {

                String dateArr[]=new String[screenDate.length];
        try {

                for(int iLoop=0; iLoop<screenDate.length; iLoop++ ){



                    String date=screenDate[iLoop].split(" ")[0];
                     date=date.replaceAll("-", "/");
//System.out.print("OraclescreenDateFormat    "+date);

			if(screenDate[iLoop]!=null && !screenDate[iLoop].trim().equals("") ) {
				SimpleDateFormat oldformat=new SimpleDateFormat("yyyy/MM/dd");
				SimpleDateFormat newformat=new SimpleDateFormat("dd/MM/yyyy");

                               Date dt = oldformat.parse(date);


				dateArr[iLoop]= newformat.format(dt).toString();


			}

                }

		}catch(Exception e) {
			System.out.print("failed to convert db date to screen date");
		}

return dateArr;

    }






}
