function include_js(path)   
{       
      var sobj = document.createElement('script');   
      sobj.type = "text/javascript";   
      sobj.src = path;   
      var headobj = document.getElementsByTagName('head')[0];   
      headobj.appendChild(sobj);   
}  
include_js("dwr/engine.js");
include_js("dwr/util.js");
include_js("dwr/interface/AjaxOrderDetailDao.js");
function landAddress()
{
	var array;
	//data = window.parent.document.getElementById("_Title_");
	array = window.parent.address;
	 var data = '';
	  
	  data += '<table  align="center" id="tableSort6"><tbody id="table7" style="text-align: center;">';
	  for (var i =0;i<array.length;i++) {
		  data+= '<tr>';
		  data+='<td><input type="radio" name="ids" id="(i+1)"/>'+" "+(i+1)+'</td>'
		  //data += '<td>' +(i+1)+ '</td>';
		  data+= '<td>' +array[i]["customerName"]+ '</td>';
		  data += '<td>' +array[i]["customerPhone"]+'</td>';
		  data += '<td>' +array[i]["customerAddress"]+'</td>';
		  data += '</tr>';
		  
	  }
	  data += '</tbody><table>';
	  	
	  document.getElementById('table_6').innerHTML = data;
	
	}

include_js("js/verify.js");
function cancel()
{
	window.parent.zDiag.close();
	
	}

var chk;
function XG(){
	var ids= document.getElementsByName("ids");
	var flag=false;
	 for(var i=0;i<ids.length;i++){
         if(ids[i].checked){
             chk = i+1;
             flag=true;
             break;
         }
     }
	 if(flag==false){
		 alert("未选择地址");
	 }else{
	 //alert(allorder[objs]["orderId"]);
	 //alert(chk);
	  var orderID=window.parent.orderIDs;
	 AjaxOrderDetailDao.changeOrderDetails(orderID,chk,bool);
	 }
    }
function bool(bool){
	if(bool==false)
  {
	alert("修改失败");	
		}else{
			alert("修改成功");
			parent.alllist();
			parent.unpaidlist();
			parent.paidlist();
			window.parent.zDiag.close();
			
			
		}
}
	
