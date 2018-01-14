/**
 \* Created with IntelliJ IDEA.
 \* Creator: LayWin
 \* CreateTime: 2018/1/13 14:55
 \* Description:
 \*/

//将中心展示图片换做所选图片
function showPic(chosenPic) {
    if (!document.getElementById){return false;}
    if (!document.getElementById("description")){return false;}
    if (!document.getElementById("placeHolder")){return false;}

    var srcTitle=chosenPic.getAttribute("title");
    var srcImg=chosenPic.getAttribute("href");

    var imgTitle=document.getElementById("description");
    var placeHolder=document.getElementById("placeHolder");

    //imgTitle.childNodes[0].nodeValue=imgTitle;
    //imgTitle.lastChild.nodeValue=imgTitle;
    imgTitle.firstChild.nodeValue=srcTitle;
    placeHolder.setAttribute("src",srcImg);

    return true;
}

//为列表链接增加点击事件
function prepareGallery() {
    if (!document.getElementsByTagName){return false;}
    var links=document.getElementsByTagName("a");
    for (var i=0; i<links.length;i++){
        links[i].onclick=function () {
            return !showPic(this);
        }
    //    links[i].onclick=links[i].onmouseover;//为链接添加onmouseover事件，事件与onclick一致
    }
}

//添加window.onload事件的工具
function addLoadEvent(func) {
    var oldOnload = window.onload;
    if(typeof window.onload != 'function'){
        window.onload = func;
    }else{
        window.onload = function () {
            oldOnload();
            func();
        }
    }
}

window.onload=addLoadEvent;
addLoadEvent(prepareGallery);
