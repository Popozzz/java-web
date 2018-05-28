// JavaScript Document 
var zDiag;
var address;
var orderIDs;
var td;
function include_js(path)   
{       
      var sobj = document.createElement('script');   
      sobj.type = "text/javascript";   
      sobj.src = path;   
      var headobj = document.getElementsByTagName('head')[0];   
      headobj.appendChild(sobj);   
}  
//验证登录
//include_js("dwr/interface/AjaxAdminDao.js");

 function check(){
      var account=document.all.account.value;
      var password=document.all.password.value;
      if(account.trim()=="")
      {
      	window.alert("账号不能为空");
      	xm.focus();
      	return(false);
      }
      if(password.trim()==""){
        window.alert("密码不能为空");
      	mm.focus();
      	return(false);
      }
      AjaxAdminDao.existAdmin(account,password,show);
      }
      
      function show(flag){
    	  alert(flag);
       if(flag==true){
    	   window.location.href="home.html";
      }else{
    	  window.alert("账号或密码不正确");
      return 0;
      }
      }
  //客户表格
      //include_js("dwr/interface/AjaxUserDao.js");
      //include_js("js/table.js");
      function user(){
    	  AjaxUserDao.getAllUser(createTable4);
      }
      
      function createTable4(array) {
       var data = '';
    
       data += '<table id="tableSort3"><tbody id="table4" style="text-align: center;line-height:2.5;">';
         

          for (var i =0;i<array.length;i++) {
        
           data += '<tr>';
            data += '<td>' +array[i]["customerId"]+ '</td>';
           data += '<td>' +array[i]["customerPassword"]+'</td>';
           data += '<td>' +array[i]["customerPhone"]+'</td>';
            data += '<td>' +array[i]["customerSum"]+'</td>';
           data += '</tr>';
           
          }
          data += '</tbody><table>';
          
          document.getElementById('table_4').innerHTML = data;
          goPagecustomer(1,10);
      }

  //查找客户
      
      function findcustomer(){
    	   var Customerphone=document.all.Customerphone.value;
    	 	  	if(Customerphone.trim()==""){
    	 	  	  window.alert("输入手机号不能为空");
    		   }
    	           AjaxUserDao.getUser(Customerphone,Resulttable);
    	 	  }
    	 	  function Resulttable(c){
    	 	  if(c==null){
    	 	  window.alert("查询无果");
    	 	  }else{
    	 	  var data = '';
    	    data += '<table id="tableSort3"><tbody id="table4" style="text-align: center;line-height:2.5;">';
    	        data += '<tr>';
    	         data += '<td>' +c["customerId"]+ '</td>';
    	        data += '<td>' +c["customerPassword"]+'</td>';
    	        data += '<td>' +c["customerPhone"]+'</td>';
    	         data += '<td>' +c["customerSum"]+'</td>';
    	        data += '</tr>';
    	       data += '</tbody><table>';
    	       document.getElementById('table_4').innerHTML = data;
    	       goPagecustomer(1,10);
    	 	  	}
    	 	  }
     
    //查看全部订单  
    	 	// include_js("dwr/interface/AjaxAddressDao.js");
    	 	function showAddressDetail(id,name)
    	 	{
    	 		//alert(allorder[obj.id]["customerId"]);

    	 		//alert(id);
    	 		//alert(name)
    	 		//alert(obj);
    	 		orderIDs=id;
    	 		
    	 		AjaxAddressDao.getAllAddress(name,showAddress);
    	 	}
    	 	 function showAddress(data)
     	 	{
    	 		address=data;

    	 		var diag = new Dialog();
    	 		zDiag = diag;
    	 		
    	 		diag.Width = 700;
    	 		diag.Height = 250;
    	 		diag.Drag=false;//不允许拖拽
    	 		diag.URL = "address.html";

    	 		diag.show();

    	 		
     	 	}
    	 	function addback()
    	 	{
    	 		var diag = new Dialog();
    	 		diag.Width = 200;
    	 		diag.Height = 100;
    	 		diag.Drag=false;//不允许拖拽
    	 		//diag.Title = "设定了高宽和标题的普通窗口";
    	 		diag.URL = "backmoney.html";
    	 		diag.show();

    	 	}
    	 	
    	 //include_js("dwr/interface/AjaxOrderDetailDao.js");
    	     
    	   function alllist(){
    		  
    		   AjaxOrderDetailDao.getAllOrderDetails(createTable1);
    		     
    	   }
    	       
    	       function createTable1(array) {
    	    	  
    	    	  
    	        var data = '';
    	        data += '<table id="tableSort"><tbody id="table1" style="text-align: center;line-height:1.5;">';
    	        
    	        for (var i =0;i<array.length;i++) {
    	    
        	        var l = new Date(array[i]["orderDate"]);
        	        
    	        	data+= '<tr>';
    	            data += '<td>' +array[i]["orderId"]+ '</td>';
    	             data+= '<td>' +array[i]["customerId"]+ '</td>';
    	            data += '<td>' +array[i]["orderTotalAmount"]+'</td>';
    	            //data += '<td>' +array[i]["orderDate"]+'</td>';
    	            data += '<td style="width:190px">' +l.toLocaleString()+'</td>';
    	             data+= '<td><a href="#"  id='+array[i]["orderId"]+' name='+array[i]["customerId"]+'  onclick="showAddressDetail(this.id,this.name)">'+array[i]["addressId"]+'</a></td>';
    	             
    	             var h="";
    	             if(array[i]["orderState"]=="1"){
    	            	 h="已付";
    	            	 data += '<td>' +h+'</td>';
        	             //data+='<td><a onclick="addback()" href="#">退款</a></td>';
    	             }else
    	              {
    	            	 h="未付";
    	            	 data += '<td>' +h+'</td>';
        	             data+='<td></td>';
    	            	 }
    	            
    	            data += '</tr>';
    	            
    	           }
    	           data += '</tbody><table>';
    	           document.getElementById('table_1').innerHTML = data;
    	           goPagealllist(1,10);
    	       }
   //查看未付订单
    	       function unpaidlist(){
        		   AjaxOrderDetailDao.getAllTypeOrderDetails(0,createTable2);
        	       }
        	       
              function createTable2(array) {
            	  var data = '';
            	  
            	  data += '<table id="tableSort1"><tbody id="table2" style="text-align: center;line-height:1.5;">';
        	          
            	  
            	  for (var i =0;i<array.length;i++) {
            		  var l = new Date(array[i]["orderDate"]);
          	   
            		  data+= '<tr>';
            		  data += '<td>' +array[i]["orderId"]+ '</td>';
            		  data+= '<td>' +array[i]["customerId"]+ '</td>';
            		  data += '<td>' +array[i]["orderTotalAmount"]+'</td>';
            		  //data += '<td>' +array[i]["orderDate"]+'</td>';
            		  data += '<td>' +l.toLocaleString()+'</td>';
            		  data+= '<td><a href="#" id='+array[i]["orderId"]+' name='+array[i]["customerId"]+'  onclick="showAddressDetail(this.id,this.name)">'+array[i]["addressId"]+'</a></td>';
            		  data += '<td>' +"未付"+'</td>';
            		  data+='<td></td>';
            		  data += '</tr>';
            		  
            	  }
            	  data += '</tbody><table>';
            	  	
            	  document.getElementById('table_2').innerHTML = data;
        	           goPageunpaidlist(1,3);
              }
   //查看已付订单
        	function paidlist(){
        		AjaxOrderDetailDao.getAllTypeOrderDetails(1,createTable3);
                 }
            	       
            function createTable3(array) {
        	        var data = '';
            	     
                data += '<table id="tableSort2"><tbody id="table3" style="text-align: center;line-height:1.5;">';
            	          

                for (var i =0;i<array.length;i++) {
                	  var l = new Date(array[i]["orderDate"]);
            	         
                	data+= '<tr>';
                	data += '<td>' +array[i]["orderId"]+ '</td>';
                	data+= '<td>' +array[i]["customerId"]+ '</td>';
                	data += '<td>' +array[i]["orderTotalAmount"]+'</td>';
                	//data += '<td>' +array[i]["orderDate"]+'</td>';
                	 data += '<td>' +l.toLocaleString()+'</td>';
                	 data+= '<td><a href="#" id='+array[i]["orderId"]+' name='+array[i]["customerId"]+'  onclick="showAddressDetail(this.id,this.name)">'+array[i]["addressId"]+'</a></td>';
                	data += '<td>' +"已付"+'</td>';
                	//data+='<td><a href="#" onclick="addback()" >退款</a></td';
                	data += '</tr>';
                	
                }
                data += '</tbody><table>';
                
                document.getElementById('table_3').innerHTML = data;
                goPagepaidlist(1,10);
            }
   //查找用户订单
            function   findorder(){
                 var orderphone=document.all.orderphone.value;
	 	  	if(orderphone.trim()==""){
	 	  	  window.alert("输入手机号不能为空");
		   }
	 	  	AjaxOrderDetailDao.getCustomerOrderDetails(orderphone,Resulttable1);
	 	  }
            function Resulttable1(array){
            	
            	if(array==null){
            		window.alert("查询无果");
            	}else{
            	var data = '';
       	     
    	        data += '<table id="tableSort"><tbody id="table1" style="text-align: center;line-height:1.5;">';
    	          
    	        for (var i =0;i<array.length;i++) {
    	        	 var l = new Date(array[i]["orderDate"]);
    	        	data+= '<tr>';
    	            data += '<td>' +array[i]["orderId"]+ '</td>';
    	             data+= '<td>' +array[i]["customerId"]+ '</td>';
    	            data += '<td>' +array[i]["orderTotalAmount"]+'</td>';
    	            //data += '<td>' +array[i]["orderDate"]+'</td>';
    	            data += '<td>' +l.toLocaleString()+'</td>';
    	            data+= '<td><a href="#" id='+array[i]["orderId"]+' name='+array[i]["customerId"]+'  onclick="showAddressDetail(this.id,this.name)">'+array[i]["addressId"]+'</a></td>';
    	             var h="";
    	             if(array[i]["orderState"]=="1"){
    	            	 h="已付";
    	            	 data += '<td>' +h+'</td>';
        	             //data+='<td><a href="#" onclick="addback()" >退款</a></td';
    	             }else
    	              {
    	            	 h="未付";
    	            	 data += '<td>' +h+'</td>';
        	             data+='<td></td>';
    	            	 
    	            	 }
    	            data += '</tr>';
    	            
    	           }
    	           data += '</tbody><table>';
    	           
    	           document.getElementById('table_1').innerHTML = data;
    	           goPagealllist(1,10);
            	}
            	}
    //查看结算清单
            //include_js("dwr/interface/AjaxOrderDao.js");
 
            function sum(){
            	var start = "2010-01-01";
            	var end=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-"+new Date().getDate();
          	  AjaxOrderDao.getSettleAccounts(start,end,createTable5);
          	  
            }
            
            function createTable5(array) {
             var data = '';
          
             data += '<table id="tableSort4"><tbody id="table5" style="text-align: center;line-height:2.5;">';
               

                for (var i =0;i<array.length;i++) {
              
                 data += '<tr>';
                  data += '<td>' +array[i]["productId"]+ '</td>';
                 data += '<td>' +array[i]["productName"]+'</td>';
                 data += '<td>' +array[i]["productPrice"]+'</td>';
                  data += '<td>' +array[i]["productNumber"]+'</td>';
                  data += '<td>' +array[i]["productTotalAmount"]+'</td>';
                 data += '</tr>';
                 
                }
                data += '</tbody><table>';
                
                document.getElementById('table_5').innerHTML = data;
                goPagesum(1,10);
            }
           
  //按时间结算
            function sumtime(){
            	var YYYY=document.all.YYYY.value;
            	var MM=document.all.MM.value;
            	var DD=document.all.DD.value;
            	var YYYY1=document.all.YYYY1.value;
            	var MM1=Number(document.all.MM1.value);
            	var DD1=Number(document.all.DD1.value);
            	
            	if(YYYY>YYYY1||YYYY==YYYY1&&MM>MM1||YYYY==YYYY1&&MM==MM1&&DD>DD1){
            		window.alert("日期选择错误，请重新选择");
            		return 0;
            	}
            	if(YYYY==""||YYYY1==""){
            		window.alert("请选择年份");
            	}else if(MM==""||MM1==""){
            		window.alert("请选择月份");
            	}else if(DD==""||DD1==""){
            		window.alert("请选择日期");
            	}else{
            	var start =YYYY+"-"+MM+"-"+DD;
            	var end=YYYY1+"-"+MM1+"-"+DD1;
          	  AjaxOrderDao.getSettleAccounts(start,end,createTable5);
            	}
            }
            
            function createTable5(array) {
            	if(array.length==0){
            		window.alert("该日期范围没有产品销售！");
            	}else{
             var data = '';
          
             data += '<table id="tableSort4"><tbody id="table5" style="text-align: center; line-height:2.5;">';
               

                for (var i =0;i<array.length;i++) {
              
                 data += '<tr>';
                  data += '<td>' +array[i]["productId"]+ '</td>';
                 data += '<td>' +array[i]["productName"]+'</td>';
                 data += '<td>' +array[i]["productPrice"]+'</td>';
                  data += '<td>' +array[i]["productNumber"]+'</td>';
                  data += '<td>' +array[i]["productTotalAmount"]+'</td>';
                 data += '</tr>';
                 
                }
                data += '</tbody><table>';
                
                document.getElementById('table_5').innerHTML = data;
                goPagesum(1,10);
            	}
            }
   //确认，取消退款
  