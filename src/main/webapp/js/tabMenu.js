// JavaScript Document for tabular Menu

function tabMenu(id,maxTabNo){
var iLoop=0;
var loopId=1;
for(iLoop=0; iLoop<maxTabNo ; iLoop++){

document.getElementById(loopId).className = "invisible";
document.getElementById('tab'+loopId).className = "select_menu_bg";

loopId++;

}

document.getElementById(id).className = "visible";
document.getElementById('tab'+id).className = "menu_bg";

}