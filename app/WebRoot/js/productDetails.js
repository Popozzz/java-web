// JavaScript Document
var data;//记录这个产品的详情
function landing()
{
	
	data = window.parent.obj;
	//alert(window.parent.obj);
	var date = new Date(data["productDate"]);
	document.getElementById("id").textContent = data["productId"];
	document.getElementById("name").textContent = data["productName"];
	document.getElementById("description").textContent = data["productDescription"];
	document.getElementById("price").textContent = data["productPrice"];
	document.getElementById("storage").textContent = data["productStorage"];
	document.getElementById("parameter").textContent = data["productParameter"];
	document.getElementById("date").textContent = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();

	var type = data["productType"];
	var typeText = document.getElementById("type");
	if(type==1)
		{
			typeText.textContent = "手机";
		}
	else if(type==2)
		{
			typeText.textContent = "电脑";
		}
	else if(type==3)
		{
			typeText.textContent = "平板";
		}
	}


function cancel()
{
	data = null;//释放内存
	window.parent.zDiag.close();//关闭弹出层
	
	}

function fix()
{

	var change = document.getElementById("change");
	var description = document.getElementById("description")
	var price = document.getElementById("price");
	var storage = document.getElementById("storage");
	var parameter = document.getElementById("parameter");
	if(change.value=="修改")
		{
			description.disabled = "";
			price.disabled = "";
			storage.disabled = "";
			parameter.disabled="";
			change.value="确定";
		}
	else
		{
		
		var description = description.value;
		var price = price.value;
		var storage = storage.value;
		var parameter = parameter.value;

			if(check(description,price,storage,parameter))
				{
					return 0;
				}
			if(confirm("确定修改？"))
			{
				AjaxProductDao.changeProduct(description,price,storage,parameter,data["productId"],changeResult);
			}
			else
			{
				return 0;
			}

		}

	
	}

function changeResult(flag)
{
	var change = document.getElementById("change");
	var description = document.getElementById("description")
	var price = document.getElementById("price");
	var storage = document.getElementById("storage");
	var parameter = document.getElementById("parameter");

	if(flag)
		{
		description.disabled = "disabled";
		price.disabled = "disabled";
		storage.disabled = "disabled";
		parameter.disabled="disabled";

		data["productDescription"] = description.value;
		data["productPrice"] = price.value;
		data["productStorage"] = storage.value;
		data["productParameter"] = parameter.value;

		change.value="修改";	
		alert("修改成功！");
		}
	else
		{
			alert("修改失败！");
		}
	}

function check(description,price,storage,parameter)
{
	//var change = document.getElementById("change");
	
	if(description==""||price==""||storage==""||parameter=="")
		{
			alert("输入不能为空！");
			return true;
		}
	else if(isNaN(Number(price)) || isNaN(Number(storage)))
		{
			alert("请输入正确的数字！")
			return true;
		}
	else if(description==data["productDescription"]&&price==data["productPrice"]&&storage==data["productStorage"]&&parameter==data["productParameter"])
		{
			alert("未做任何修改！");
			return true;
		}
	}

function deleteProduct()
{
	if(confirm("确定删除？"))
		{
			AjaxProductDao.deleteProduct(data["productId"],dProduct);
		}
	else
		{
			return 0;
		}
	
	}

function dProduct(flag)
{
	var page;
	if(flag==true)
		{
			alert("删除成功！");
			window.parent.removeAll();
			window.parent.landing();
			//window.parent.location.reload();
			data = null;//清除内存
			window.parent.zDiag.close();//关闭弹出层
			
		}
	else
		{
			alert("删除失败！")
		}
	}
