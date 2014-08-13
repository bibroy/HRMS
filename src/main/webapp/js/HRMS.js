//Checks if input is blank

function isBlank(val){
    return (trim(val)=='');
}
function trim(str){
    return str.replace(/^\s+|\s+$/g, '');
}


function checkBlank(ctrl,ctrlName){
    if (ctrl.value!=null && trim(ctrl.value)!=''){

        return true;

    }
    if(!ctrlName || ctrlName=='')
        alert ("Field cannot be blank");
    else
        alert(ctrlName + " cannot be blank");
    document.getElementById("errorMsg").innerHTML=ctrlName +" Can't be Blank!!";
    document.getElementById("errorMsg").className="errorMsg";

    ctrl.focus();
    return false;
}

//**************************************Added by Shrayanti***************************************//


function checkChar(ctrl,ctrlName){

    validRegExp = /^[A-Z-a-z ]{1,40}\s?$/i;
    if (ctrl.value.search(validRegExp)== -1){
        alert(ctrlName + " Please Enter Valid Name..");
        document.getElementById("errorMsg").innerHTML=" Please Enter Valid  "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        ctrlName.select();
        return false;

    }
    else
        return true;

}





function checkOption(ctrl,ctrlName){
    if(ctrl.options.selectedIndex == 0){
        alert('Please choose an option as'+ctrlName);
        document.getElementById("errorMsg").innerHTML=" Please choose an option as "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";
        ctrl.options.focus();

        return false;
    }
    else
        return true;

}

function checkEmail(ctrl,ctrlName){

    validRegExp = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i;
    if (ctrl.value.search(validRegExp) == -1){
        alert("Please Enter Valid"+ctrlName);
        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";
        ctrl.focus();
        return false;

    }
    else
        return true;

}

function checkPhnNo(ctrl,ctrlName){

    validRegExp = /^[0-9]{10,15}$/i;
    if (ctrl.value.search(validRegExp) == -1){
        alert("Please Enter Valid"+ctrlName);

        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        return false;
    }

    else
        return true;
}

//**************************************Added by Sudip***************************************//


function checkNumber(ctrl,ctrlName){

    validRegExp = /^[0-9]{5,100}$/i;
    if (ctrl.value.search(validRegExp) == -1){


        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        return false;
    }

    else
        document.getElementById("errorMsg").innerHTML="";
    return true;

}

function checkNum(ctrl,ctrlName){

    validRegExp = /^(\d)*$/;
    if (ctrl.value.search(validRegExp) == -1){


        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        return false;
    }

    else
        document.getElementById("errorMsg").innerHTML="";
    return true;

}


function checkAddress(ctrl,ctrlName){

    validRegExp = /^[A-Z-a-z0-9,./ ]{1,40}$/i;
    if (ctrl.value.search(validRegExp)== -1){
        alert(ctrlName + " Please Enter Valid Text..");
        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";
        ctrl.focus();
        return false;

    }
    else
        return true;

}




function checkZipCode(ctrl,ctrlName){

    validRegExp = /^[0-9]{4,15}$/i;
    if (ctrl.value.search(validRegExp) == -1){
        alert("Please Enter Valid"+ctrlName);

        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        return false;
    }

    else
        return true;
}




function checkPercentage(ctrl,ctrlName){

    validRegExp = /^[0-9.]{1,3}$/i;
    if (ctrl.value.search(validRegExp) == -1){
        alert("Please Enter Valid"+ctrlName);

        document.getElementById("errorMsg").innerHTML=" Please Enter Valid "+ctrlName +"!!";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        return false;
    }


    if (eval(ctrl.value)>100 || eval(ctrl.value)<=0 ){
        alert(ctrlName +" must less   than equal 100 or grater than Zero");

        document.getElementById("errorMsg").innerHTML=ctrlName +" must less  than equal 100 or grater than Zero";
        document.getElementById("errorMsg").className="errorMsg";

        ctrl.focus();
        return false;
    }




    else
        return true;
}





////Check Radio BTN
function valButton(btn) {
    var cnt = -1;
    for (var i=btn.length-1; i > -1; i--) {
        if (btn[i].checked) {
            cnt = i;
            i = -1;
        }
    }
    if (cnt > -1) return btn[cnt].value;
    else return null;
}
function checkRadio(ctrl,ctrlName) {
    var btn = valButton(ctrl);
    if (btn == null){
        alert('No radio button selected as '+ctrlName);
        document.getElementById("errorMsg").innerHTML=ctrlName +" must less   than 100 or grater than Zero";
        document.getElementById("errorMsg").className="errorMsg";
        ctrl.focus();
        return false;
    }
    else
        return true;
}





//  start upload image check


/***** CUSTOMIZE THESE VARIABLES *****/

// width to resize large images to
var maxWidth=100;
// height to resize large images to
var maxHeight=100;
// valid file types
var fileTypesImages=["jpg"];
// the id of the preview image tag
var outImage="previewField";
// what to display when the image is not valid
var defaultPic="../images/spacer.gif";

/***** DO NOT EDIT BELOW *****/

function checkImage(ctrl,ctrlName){
    var source=ctrl.value;
    var ext=source.substring(source.lastIndexOf(".")+1,source.length).toLowerCase();
    for (var i=0; i<fileTypesImages.length; i++) if (fileTypesImages[i]==ext) break;
    globalPic=new Image();
    if (i<fileTypesImages.length) globalPic.src=source;
    else {
        globalPic.src=defaultPic;
        alert("THAT IS NOT A VALID IMAGE\nPlease load an image with an extention of one of the following:\n\n"+fileTypesImages.join(", "));
        return false;
    }
    // setTimeout("applyChanges()",200);
    return true;
}
/*
var globalPic;
function applyChanges(){
  var field=document.getElementById(outImage);
  var x=parseInt(globalPic.width);
  var y=parseInt(globalPic.height);
  if (x>maxWidth) {
    y*=maxWidth/x;
    x=maxWidth;
  }
  if (y>maxHeight) {
    x*=maxHeight/y;
    y=maxHeight;
  }
  field.style.display=(x<1 || y<1)?"none":"";
  field.src=globalPic.src;
  field.width=x;
  field.height=y;
}*/
// End -->
//end image check
//Check Doc File
var fileTypesDoc=["doc"];
function checkFile(ctrl,ctrlName){
    var source=ctrl.value;
    var ext=source.substring(source.lastIndexOf(".")+1,source.length).toLowerCase();
    for (var i=0; i<fileTypesDoc.length; i++) if (fileTypesDoc[i]==ext) break;
    globalPic=new Image();
    if (i<fileTypesDoc.length) globalPic.src=source;
    else {
        globalPic.src=defaultPic;
        alert("THAT IS NOT A VALID Document \nPlease load an Document with an extention of one of the following:\n\n"+fileTypesDoc.join(", "));
        return false;
    }
    // setTimeout("applyChanges()",200);
    return true;
}
/// end doc file check
///

var fileTypesExcel=["xls"];
function checkExcelFile(ctrl,ctrlName){

    var source=ctrl.value;

    var ext=source.substring(source.lastIndexOf(".")+1,source.length).toLowerCase();
    for (var i=0; i<fileTypesExcel.length; i++) if (fileTypesExcel[i]==ext) break;
    globalPic=new Image();

    if (i<fileTypesExcel.length) globalPic.src=source;
    else {
        globalPic.src=defaultPic;
        alert("THAT IS NOT A VALID Document \nPlease load an Document with an extention of one of the following:\n\n"+fileTypesExcel.join(", "));
        return false;
    }
    // setTimeout("applyChanges()",200);
    return true;
}


function cancelPage(urlPath)
{
    document.location.href=urlPath;

}

////
//**********************************************************************************************************//