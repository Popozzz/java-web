// JavaScript Document
//页面初始化
var obj;//记录被点击的产品对象
var zDiag;//记录当前弹出框
var page;//记录当前页
var pageSum;//记录总页数
var newProduct;//记录添加的产品

function landing()
{
	//alert("刷新了");
	AjaxProductDao.getAllProduct(showAllProduct);
	page = 0;
	pageSum = 0;
	
	
	}

function add()
{
	var diag = new Dialog();
	zDiag = diag;
	diag.Width = 460;
	diag.Height = 670;
	diag.Drag=false;//不允许拖拽
	//diag.Title = "设定了高宽和标题的普通窗口";
	diag.URL = "add.html";
	diag.show();
}

function showAllProduct(data)
{

	pageSum = Math.ceil(data.length/8);

	showProductList(data);
	document.getElementById("next").onclick = nextPage;
	document.getElementById("last").onclick = lastPage;
	document.getElementById("first").onclick = firstPage;
	
	function nextPage()
	{
		if((page+1)<=(pageSum-1))
			{
				page = page + 1;
				removeAll();
				showProductList(data);
			}
		else
			{
				alert("当前页是最后一页！");
			}
		}

	function lastPage()
	{
		if(page>=1)
			{
				page = page - 1;
				removeAll();
				showProductList(data);
			}
		else
			{
				alert("当前页是首页！");
			}
		
		}
	function firstPage()
	{

		if(page==0)
			{
				alert("当前页已经是首页！");
			}
		page = 0;
		removeAll();
		showProductList(data);
		}
		
}

function showProductList(data)
{
	
	var i = page*8;
	//alert(data.length);
	var div = document.getElementById("product");
	//alert(pageSum);
	text=" margin-top:2px;margin-bottom:30px;margin-left:30px;margin-right:30px;border: 1px solid #000000;height: 280px;width: 194px; display:inline-block ;text-align: center;padding-top: 5px;padding-right: 5px;padding-bottom: 5px;padding-left: 5px;";
	for(i;i<data.length;i++)
	{
		var url="http://172.28.200.17:8080/upload/image/"
		if(i%4==0)
		{
			var br = document.createElement("br");
			div.appendChild(br);
			}
		var product = document.createElement("div");
		product.style.cssText= text;//设置CSS样式
		product.align="left";
		
		var a = document.createElement("a");
		a.href="#";
		product.appendChild(a);
		var img = document.createElement("img");
		img.src=url+data[i]["productImg"];
		img.alt=data[i]["productId"];//存放productID
		img.width="190";
		img.height="223";
		//img.id=i-page*8;
		img.onclick=showProductDetail;

		a.appendChild(img);
		
		var littlediv = document.createElement("div");
		littlediv.style.cssText="text-align: center;font-weight: normal;width: 120px;margin: 2px;height:50px;padding:2px;text-indent:2em;";
		littlediv.textContent=data[i]["productName"];
		product.appendChild(littlediv);
		
		div.appendChild(product);
		if(i==page*8+7)
			{break;}
		
		}
	
	}

function showProductDetail()
{
	var pid;
	pid = this.alt;

	AjaxProductDao.getProduct(pid,showProduct);
}

function showProduct(data)
{
	obj=data;

	var diag = new Dialog();
	zDiag = diag;
	
	diag.Width = 450;
	diag.Height = 680;
	diag.Drag=false;//不允许拖拽
	diag.Title = data["productName"];
	diag.URL = "productDetails.html";

	diag.show();
	//alert(document.getElementById("name"));
	
	}

function getKeyProduct()
{
	var key = document.getElementById("searchProduct").value;
	//alert(key);
	AjaxProductDao.findKeyProduct(key,showKeyProduct);
	
	}

function showKeyProduct(data)
{
	page = 0;
	pageSum = Math.ceil(data.length/8);

	removeAll();
	showProductList(data);	
	
	document.getElementById("next").onclick = nextPage;
	document.getElementById("last").onclick = lastPage;
	document.getElementById("first").onclick = firstPage;
	function nextPage()
	{
		if((page+1)<=pageSum)
			{
				page = page + 1;
				removeAll();
				showProductList(data);
			}
		else
			{
				alert("当前页是最后一页！");
			}
		}

	function lastPage()
	{
		if(page>=1)
			{
				page = page - 1;
				removeAll();
				showProductList(data);
			}
		else
			{
				alert("当前页是首页！");
			}
		
		}
	function firstPage()
	{
		if(page==0)
			{
				alert("当前页已经是首页！");
			}
		page = 0;
		removeAll();
		showProductList(data);
		}
		
	}




function removeAll()
{
	var div = document.getElementById("product");
	while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
    {
        div.removeChild(div.firstChild);
    }
	
}

function all()
{
	alert("all");
	removeAll();
	landing();
	}

