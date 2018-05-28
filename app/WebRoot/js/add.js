// JavaScript Document

function check(add)
{

	var name = document.all.addName.value;
	var description = document.all.addDescription.value;
	var price = document.all.addPrice.value;
	var storage = document.all.addStorage.value;
	var parameter = document.all.addParameter.value;
	//alert(name);
	
	if(name=""||description==""||price==""||storage==""||parameter=="")
	{
		alert("输入不能为空！");
		return false;
	}
	else if(isNaN(Number(price)) || isNaN(Number(storage)))
	{
		alert("请输入正确的数字！")
		return false;
	}
	add.click();

	}