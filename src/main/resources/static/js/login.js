/**
 \* Created with IntelliJ IDEA.
 \* Creator: LayWin
 \* CreateTime: 2018/1/14 1:45
 \* Description:
 \*/

function getThisYear() {
    var copyRight=document.getElementById("copyRight");
    var copyHead=copyRight.innerText;
    if(2012<new Date().getFullYear()){
        copyRight.innerText=copyHead+" - "+new Date().getFullYear()+" Weyland Corp . All Rights Reserved .";
    }
}

window.onload=getThisYear;