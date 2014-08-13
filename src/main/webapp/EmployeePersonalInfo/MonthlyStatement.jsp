<%-- 
    Document   : MonthlyStatement
    Created on : Dec 13, 2010, 5:50:24 PM
    Author     : Sumit Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="java.util.*" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS :: Monthly Salary Statement</title>
        <script type="text/javascript" src="js/ajaxpagefetcher.js"> </script>
        <script type="text/javascript" src="js/calender/viewCalendar.js"> </script>
        <script language="javascript" type="text/JavaScript" src="js/HRMS.js"></script>
        <script language="javascript" type="text/JavaScript" src="js/tabMenu.js"></script>
        
        <link rel="stylesheet" type="text/css" href="css/newstyle.css"/>
        <link rel="stylesheet" href="css/newstyle1.css" />

        <script type="text/JavaScript">

            function addRec(form){
                form.method.value="addEmployeePersonalInfo";


                if(ipFieldValidation(form)){

                    form.submit();


                    //    document.getElementById("empCerationForm").className="submitAction";
                    //   document.getElementById("submitBtn").disabled = true;

                }
                else{

                    return false;
                }

            }

            function selDselField(form,id){

                if(form.reEmpStatus.checked==true){

                    document.getElementById(id).disabled=false;
                }
                else if(form.reEmpStatus.checked==false){

                    document.getElementById(id).disabled=true;

                }
            }
        </script>
        <script language="javascript" type="text/javascript">
            function Clickheretoprint()
            {
                var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,";
                disp_setting+="scrollbars=yes,width=950, height=535, left=100, top=25";
                var content_vlue = document.getElementById("print_content").innerHTML;

                var docprint=window.open("","",disp_setting);
                docprint.document.open();
                docprint.document.write('<html><head><title>Monthly Statement</title>');
                docprint.document.write('</head><body onLoad="self.print()"><center>');
                docprint.document.write('<h1>Orbit Web Solutions Pvt. Ltd.</h1>');
                docprint.document.write(content_vlue);
                docprint.document.write('<h4 align="right">Authorized Signatory</h4>');
                docprint.document.write('</center></body></html>');
                docprint.document.close();
                docprint.focus();
            }

            var basic;

            function loadbasicsal(form)
            {
                var empId=form.empId.value;
              
                var basicsal="GetSalaryForLoan.do?method=getTotalSalary&hiddenId="+empId;
                
                ajaxpagefetcher.load('basicSal', basicsal ,true);
              
            }

            function calcHra(hra)
            {
                basic=document.getElementById("sal").value;
                hra.value=(basic*10) /100;
            }
            function calcIns(ins)
            {
                basic=document.getElementById("sal").value;
                ins.value=(basic*5) /100;
            }
            function calcDa(da)
            {
                basic=document.getElementById("sal").value;
                da.value=(basic*20)/100;
            }
            function calcPt(pt)
            {
                basic=document.getElementById("sal").value;
                pt.value=(basic*1)/100;
            }
            function calcCa(ca)
            {
                basic=document.getElementById("sal").value;
                ca.value=(basic*5)/100;
            }
            function calcPc(pc)
            {
                basic=document.getElementById("sal").value;
                pc.value=(basic*1)/100;
            }
            function calcAa(aa)
            {
                basic=document.getElementById("sal").value;
                aa.value=(basic*2)/100;
            }

            function loadadvsal(form)
            {
                var empId=form.empId.value;
                var month=form.month.value;
                var year=form.year.value;
                var advsal="getAdvSal.do?method=getAdvancedSalary&hiddenId="+empId+"&month="+month+"&year="+year;
                
                ajaxpagefetcher.load('advancedSal', advsal ,true);

            }

            function loadleaveded(form)
            {
                var empId=form.empId.value;
                var month=form.month.value;
                var year=form.year.value;
                var leaveded="getLeaveDed.do?method=getLeaveDeduction&hiddenId="+empId+"&month="+month+"&year="+year;
                ajaxpagefetcher.load('leaveDeduction',leaveded,true);
            }

            function calctotal(form)
            {
                var basic=parseFloat(document.getElementById("sal").value);
                var hra=parseFloat(form.hra.value);
                var da=parseFloat(form.da.value);
                var ca=parseFloat(form.ca.value);
                var aa=parseFloat(form.aa.value);
                var ins=parseFloat(form.ins.value);
                var pt=parseFloat(form.pt.value);
                var pc=parseFloat(form.pc.value);
                var advsal=parseFloat(form.advSal.value);
                var leaveded=parseFloat(form.leaveDed.value);
                var ear=(basic+hra+da+ca+aa);
                var ded=(ins+pt+pc+advsal+leaveded);
            
                var net=ear-ded;
                form.netPayable.value=net;
             
            }

            function savenetpayable(form)
            {
                form.method.value="saveNetPayable";
                form.hiddenId.value=form.empId.value;
                form.submit();
            }
        </script>

    </head>
    <body background="palegoldenrod">

        <jsp:include page="../include/header.jsp" />
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="8"></td>
                <td height="8"></td>
                <td height="8"></td>
            </tr>
            <tr>
               <td width="100%" colspan="3" align="left" valign="top"><img src="images/Employee.jpg" width="100%" height="138" /></td>
            </tr>
            <tr>
                <td height="3"></td>
                <td height="3"></td>
                <td height="3"></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="237" align="right" valign="top" bgcolor="#FFFFFF">
                    <br/>
                    <jsp:include page="../include/menu1.jsp"/>
                </td>
                <td align="left" valign="top" bgcolor="#FFFFFF"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td><table width="97%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <%--
                                <tr>
                                  <td width="141" align="left" valign="top"><a href="test_form1.jsp"><img src="images/tab1_button_roll.jpg" name="Image1" width="141" height="30" border="0" id="Image1" onmouseover="MM_swapImage('Image1','','images/tab1_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td width="2" align="left" valign="top">&nbsp;</td>
                                  <td width="141"><a href="test_form2.jsp"><img src="images/tab2_button_nor.jpg" width="141" height="30" border="0" id="Image2" onmouseover="MM_swapImage('Image2','','images/tab2_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td width="2" align="left" valign="top">&nbsp;</td>
                                  <td width="187"><a href="test_form3.jsp"><img src="images/tab3_button_nor.jpg" width="187" height="30" border="0" id="Image3" onmouseover="MM_swapImage('Image3','','images/tab3_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td width="2">&nbsp;</td>
                                  <td width="141" align="left" valign="top"><a href="test_form4.jsp"><img src="images/tab4_button_nor.jpg" width="141" height="30" border="0" id="Image4" onmouseover="MM_swapImage('Image4','','images/tab4_button_roll.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                                  <td>&nbsp;</td>
                                </tr>
                                    --%>
                                </table></td>
                        </tr>
                        <tr>
                            <td>
                                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="box">
                                    <tr>
                                        <td width="10" class="box_left_bg"><img src="images/box_left_top_corner.jpg" width="10" height="10" /></td>
                                        <td class="box_top_bg">&nbsp;</td>
                                        <td width="11" align="right" valign="top" class="box_right_bg"><img src="images/box_right_top_corner.jpg" width="11" height="10" /></td>
                                    </tr>
                                    <tr>
                                        <td class="box_left_bg">&nbsp;</td>
                                        <td align="center" valign="middle">
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                <tr style="height: 200px;">
                                                    <td align="left" valign="top">

                                                        <%-- Main Page Content Starts Here --%>


                                                        <html:form action="monthlyStatement" method="post"  styleClass="none" styleId="empCerationForm">
                                                            <!--Start Main table-->
                                                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                                <tr>
                                                                    <td align="left" valign="top"><div id="errorMsg" ></div>

                                                                        <logic:messagesPresent message="true">

                                                                            <font color="green"> <b><img src="images/success.jpg" width="24" height="22" />&nbsp;&nbsp; <html:messages id="msg" message="true"><bean:write name="msg"/></html:messages></b></font>

                                                                        </logic:messagesPresent>
                                                                        <logic:messagesPresent >

                                                                            <html:messages id="error"><bean:write name="error"/></html:messages>

                                                                        </logic:messagesPresent >

                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top" id="print_content"><!--Start Personal Info table-->
                                                                        <h3 align="center"><u>Monthly Statement / Transaction </u></h3>
                                                                        <table width="100%" border="0" cellspacing="4" cellpadding="2" >
                                                                            <tr>
                                                                                <td colspan="2" nowrap="nowrap"><span class="normal_black_text" style="font-weight: bold">Fill Up all Mandatory fields(</span><span class="normal_black_text"><span class="style3">*</span></span><span class="normal_black_text" style="font-weight: bold">):- </span></td>
                                                                                <td colspan="2" nowrap="nowrap">&nbsp;</td>
                                                                                <td colspan="2" nowrap="nowrap">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Employee : </td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">
                                                                                    <html:select property="empId" onchange="loadbasicsal(this.form);">
                                                                                        <html:option value="">---Select--</html:option>
                                                                                        <logic:present name="Employees" scope="request">
                                                                                            <html:options collection="Employees" property="employeeid" />
                                                                                        </logic:present>
                                                                                    </html:select>
                                                                                </td>
                                                                                <td  align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Month : </td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">
                                                                                    <html:select property="month" value="11">
                                                                                        <html:option value="">--Select--</html:option>
                                                                                        <html:option value="1">Jan</html:option>
                                                                                        <html:option value="2">Feb</html:option>
                                                                                        <html:option value="3">Mar</html:option>
                                                                                        <html:option value="4">Apr</html:option>
                                                                                        <html:option value="5">May</html:option>
                                                                                        <html:option value="6">Jun</html:option>
                                                                                        <html:option value="7">Jul</html:option>
                                                                                        <html:option value="8">Aug</html:option>
                                                                                        <html:option value="9">Sep</html:option>
                                                                                        <html:option value="10">Oct</html:option>
                                                                                        <html:option value="11">Nov</html:option>
                                                                                        <html:option value="12">Dec</html:option>
                                                                                    </html:select>
                                                                                </td>
                                                                                <td align="left" valign="middle" nowrap="nowrap"><span class="style3">*</span>Year : </td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">
                                                                                    <html:select property="year" value="2010">
                                                                                        <html:option value="">--Select--</html:option>
                                                                                        <html:option value="2015">2015</html:option>
                                                                                        <html:option value="2014">2014</html:option>
                                                                                        <html:option value="2013">2013</html:option>
                                                                                        <html:option value="2012">2012</html:option>
                                                                                        <html:option value="2011">2011</html:option>
                                                                                        <html:option value="2010">2010</html:option>
                                                                                        <html:option value="2009">2009</html:option>
                                                                                        <html:option value="2008">2008</html:option>
                                                                                        <html:option value="2007">2007</html:option>
                                                                                        <html:option value="2006">2006</html:option>
                                                                                        <html:option value="2005">2005</html:option>
                                                                                        <html:option value="2004">2004</html:option>
                                                                                    </html:select>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap>Basic Salary:</td>
                                                                                <td align="right" valign="middle" nowrap id="basicSal"><html:text property="basic"  readonly="true" /></td>
                                                                                <td align="right" valign="middle" nowrap>&nbsp;</td>
                                                                                <td align="left" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                <td align="right" valign="middle" nowrap="nowrap">&nbsp;</td>
                                                                                <td align="right" valign="middle" nowrap>&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td colspan="6">
                                                                                    <table width="100%" border="2" style="border-width: thin; border-color: #915727; border-style-inner: solid;" cellspacing="4" cellpadding="2" >
                                                                                        <tr>
                                                                                            <td colspan="3" style="text-align: center; font-weight: bold; font-size: large">Allowances</td>
                                                                                            <td colspan="3" style="text-align: center; font-weight: bold; font-size: large">Deductions</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>S.No.</td>
                                                                                            <td>Allowance</td>
                                                                                            <td>Amount</td>
                                                                                            <td>Sl.No.</td>
                                                                                            <td>Deduction</td>
                                                                                            <td>Amount</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>1</td>
                                                                                            <td>House Rent Allowance</td>
                                                                                            <td><html:text property="hra" readonly="true" onclick="calcHra(this);"/></td>
                                                                                            <td>1</td>
                                                                                            <td>Insurance</td>
                                                                                            <td><html:text property="ins" readonly="true" onclick="calcIns(this)"/></td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>2</td>
                                                                                            <td>Dearness Allowance</td>
                                                                                            <td><html:text property="da" readonly="true" onclick="calcDa(this)"/></td>
                                                                                            <td>2</td>
                                                                                            <td>Medical Card Charges</td>
                                                                                            <td><html:text property="pt" readonly="true" onclick="calcPt(this)"/></td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>3</td>
                                                                                            <td>Car Allowance</td>
                                                                                            <td><html:text property="ca" readonly="true" onclick="calcCa(this)"/></td>
                                                                                            <td>3</td>
                                                                                            <td>Petrol Charges</td>
                                                                                            <td><html:text property="pc" readonly="true" onclick="calcPc(this)"/></td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>4</td>
                                                                                            <td>Attire Allowance</td>
                                                                                            <td><html:text property="aa" readonly="true" onclick="calcAa(this)"/></td>
                                                                                            <td></td>
                                                                                            <td></td>
                                                                                            <td></td>
                                                                                        </tr>
                                                                                    </table>

                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="left" valign="middle" nowrap>Advanced Salary Taken:</td>
                                                                                <td align="right" valign="middle" nowrap id="advancedSal"><html:text property="advSal" readonly="true" onclick="loadadvsal(this.form);"/></td>
                                                                                <td align="left" valign="middle" nowrap >Leave Deductions:</td>
                                                                                <td align="right" valign="middle" nowrap id="leaveDeduction"><html:text property="leaveDed" readonly="true" onclick="loadleaveded(this.form);"/></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Calculated Net Payable: </td>
                                                                                <td><html:text property="netPayable" readonly="true" onclick="calctotal(this.form);"/></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td></td>
                                                                                <td>
                                                                                    <html:button property="button" value="   Print  " onclick="Clickheretoprint();"/>
                                                                                </td>
                                                                                <td>
                                                                                    <html:button property="button" value="  Save  " onclick="savenetpayable(this.form);"/>
                                                                                </td>
                                                                                <td>
                                                                                    <html:reset value="  Reset  "/>
                                                                                </td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top"></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top">&nbsp;</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="left" valign="top">&nbsp;</td>
                                                                </tr>
                                                            </table>
                                                            <!--End Main Table-->
                                                            <html:hidden property="method"/>
                                                            <html:hidden property="hiddenId"/>
                                                        </html:form>



                                                        <%-- Main Page Content Ends Here --%>

                                                    </td>
                                                </tr>
                                            </table></td>
                                        <td class="box_right_bg">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td align="left" valign="bottom" class="box_left_bg"><img src="images/box_left_buttom_corner.jpg" width="10" height="12" /></td>
                                        <td class="box_buttom_bg">&nbsp;</td>
                                        <td align="right" valign="bottom" class="box_right_bg"><img src="images/box_right_buttom_corner.jpg" width="11" height="12" /></td>
                                    </tr>
                                </table></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </table></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="16" align="left" valign="top" bgcolor="#FFFFFF"><img src="images/body_left_bottom_round.jpg" width="16" height="14" /></td>
                <td bgcolor="#FFFFFF">&nbsp;</td>
                <td width="16" align="right" valign="top" bgcolor="#FFFFFF"><img src="images/body_right_bottom_round.jpg" width="16" height="14" /></td>
            </tr>
        </table>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="3"></td>
            </tr>
        </table>
        <jsp:include page="../include/footer.jsp" />
        <script type="text/javascript">
        $(function() {
        	//loadAccordions();
	        	$( "#accrdins" ).accordion({
	        		collapsible: true,
	        		active: 10
	        	});
        	});

        </script>
    </body>
</html>

