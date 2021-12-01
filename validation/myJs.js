
function notEmpty(elem,msg)
{
if(elem.value.length==0)
{
alert(msg);
elem.focus();
return false;
}
return true;
}

function addrValid(elem,msg)
{
var exp=/^[ a-zA-Z0-9\,\:\-]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}

function compValid(elem1,elem2,msg)
{
if(elem1.value!=elem2.value)
{
alert(msg);
elem2.focus();
return false;
}
return true;
}


function emailValid(elem,msg)
{
var exp=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}


function mustSelect(elem,msg)
{
if(elem.value=="Select One")
{
alert(msg);
elem.focus();
return false;
}
return true;
}

function onlyAlpha(elem,msg)
{
var exp=/^[ a-zA-Z]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}

function onlyDigits(elem,msg)
{
var exp=/^[0-9]+$/;
if(!(elem.value.match(exp)))
{
alert(msg);
elem.focus();
return false;
}
return true;
}

function rangeValid(elem,min,max,msg)
{
if(!(elem.value.length>=min && elem.value.length<=max))
{
alert(msg);
elem.focus();
return false;
}
return true;
}

function rangeValidN(elem,min,max,msg)
{
if(!(parseInt(elem.value)>=min && parseInt(elem.value)<=max))
{
alert(msg);
elem.focus();
return false;
}
return true;
}
