﻿// JavaScript Document

//切换界面
       

      function showDiv(d){
		  switch(d)
		  {
			  case 'page1':
			            document.getElementById(d).style.display='block';
		                document.getElementById("page2").style.display="none";
                        document.getElementById("page3").style.display="none"; 
						document.getElementById("page4").style.display="none";  
						break;
			 case 'page2':
			 			document.getElementById(d).style.display='block';
		                document.getElementById("page1").style.display="none"; 
						document.getElementById("page3").style.display="none"; 
						document.getElementById("page4").style.display="none"; 
						break;
			 case 'page3':
			 			document.getElementById(d).style.display='block';
		                document.getElementById("page1").style.display="none";  
						document.getElementById("page2").style.display="none"; 
						document.getElementById("page4").style.display="none"; 
						break;
			case 'page4':
			 			document.getElementById(d).style.display='block';
		                document.getElementById("page1").style.display="none";  
						document.getElementById("page2").style.display="none"; 
						document.getElementById("page3").style.display="none"; 
						break;
			case 'alllist':
			            document.getElementById(d).style.display='block';
		                document.getElementById("unpaidlist").style.display="none";  
						document.getElementById("paidlist").style.display="none"; 
						break;
			case 'unpaidlist':
			            document.getElementById(d).style.display='block';
		                document.getElementById("alllist").style.display="none";  
						document.getElementById("paidlist").style.display="none"; 
						break;
			case 'paidlist':
			            document.getElementById(d).style.display='block';
		                document.getElementById("unpaidlist").style.display="none";  
						document.getElementById("alllist").style.display="none"; 
						break;
			
		  }
	  }
	  //选择年/月  销量
	  
      function YYYYMMDDstart() {
          MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
          //先给年下拉框赋内容   
          var y = new Date().getFullYear();
          for (var i = (y-7); i < y+1; i++)   
              document.reg_testdate.YYYY.options.add(new Option(" " + i + " 年", i));
          //赋月份的下拉框   
          for (var i = 1; i < 13; i++)
              document.reg_testdate.MM.options.add(new Option(" " + i + " 月", i));
          document.reg_testdate.YYYY.value = y;
          document.reg_testdate.MM.value = new Date().getMonth() + 1;
          var n = MonHead[new Date().getMonth()];
          if (new Date().getMonth() == 1 && IsPinYear(YYYYvalue)) n++;
          writeDay(n); //赋日期下拉框Author:meizz   
          document.reg_testdate.DD.value = new Date().getDate();
      }
     

      function YYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)   
      {
          var MMvalue = document.reg_testdate.MM.options[document.reg_testdate.MM.selectedIndex].value;
          if (MMvalue == "") {
              var e = document.reg_testdate.DD;
              optionsClear(e);
              return;
          }
          var n = MonHead[MMvalue - 1];
          if (MMvalue == 2 && IsPinYear(str)) n++;
			
          writeDay(n)
      }

      function MMDD(str) //月发生变化时日期联动   
      {
          var YYYYvalue = document.reg_testdate.YYYY.options[document.reg_testdate.YYYY.selectedIndex].value;
          if (YYYYvalue == "") {
              var e = document.reg_testdate.DD;
              optionsClear(e);
              return;
          }
          var n = MonHead[str - 1];
          if (str == 2 && IsPinYear(YYYYvalue)) n++;
          writeDay(n)
      }
		

      function writeDay(n) //据条件写日期的下拉框   
      {
          var e = document.reg_testdate.DD;
          optionsClear(e);
          for (var i = 1; i < (n + 1); i++)
              e.options.add(new Option(" " + i + " 日", i));
      }

      function IsPinYear(year) //判断是否闰平年   
      {
          return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0));
      }

      function optionsClear(e) {
          e.options.length = 1;
      }
		
		
function YYYYMMDDstart1() {
          MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
          //先给年下拉框赋内容   
          var y = new Date().getFullYear();
          for (var i = (y-7); i < y+1; i++) //以今年为准，前30年，后30年   
              document.reg_testdate.YYYY1.options.add(new Option(" " + i + " 年", i));
          //赋月份的下拉框   
          for (var i = 1; i < 13; i++)
              document.reg_testdate.MM1.options.add(new Option(" " + i + " 月", i));
          document.reg_testdate.YYYY1.value = y;
          document.reg_testdate.MM1.value = new Date().getMonth() + 1;
          var n = MonHead[new Date().getMonth()];
          if (new Date().getMonth() == 1 && IsPinYear(YYYY1value)) n++;
          writeDay1(n); //赋日期下拉框Author:meizz   
          document.reg_testdate.DD1.value = new Date().getDate();
      }
		
		function YYYYDD1(str) //年发生变化时日期发生变化(主要是判断闰平年)   
      {
          var MMvalue = document.reg_testdate.MM1.options[document.reg_testdate.MM1.selectedIndex].value;
          if (MMvalue == "") {
              var e = document.reg_testdate.DD1;
              optionsClear(e);
              return;
          }
			
          var n = MonHead[MMvalue - 1];
			
          if (MMvalue == 2 && IsPinYear(str)) n++;
          writeDay1(n)
      }

      function MMDD1(str) //月发生变化时日期联动   
      {
          var YYYYvalue = document.reg_testdate.YYYY1.options[document.reg_testdate.YYYY1.selectedIndex].value;
          if (YYYYvalue == "") {
              var e = document.reg_testdate.DD1;
              optionsClear(e);
              return;
          }
          var n = MonHead[str - 1];
          if (str == 2 && IsPinYear(YYYYvalue)) n++;
          writeDay1(n)
      }
		

      function writeDay1(n) //据条件写日期的下拉框   
      {
          var e = document.reg_testdate.DD1;
          optionsClear(e);
          for (var i = 1; i < (n + 1); i++)
              e.options.add(new Option(" " + i + " 日", i));
      }

		
if(document.attachEvent) {
	  window.attachEvent("onload", YYYYMMDDstart);
    window.attachEvent("onload", YYYYMMDDstart1); 
	 }    
else  {
		window.addEventListener("load", YYYYMMDDstart, false); 
		window.addEventListener("load", YYYYMMDDstart1, false); 		
	 } 
