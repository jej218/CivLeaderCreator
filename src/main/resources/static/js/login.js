/**
 * 
 */
  


if(document.getElementById("modal1") != null ){
	var element = document.getElementById("modal1");
	var instance = M.Modal.init(element, {dismissible: false, opacity: 1});
	console.log(instance);
	instance.open();
	
}

var elements = document.querySelectorAll(".tooltipped");
M.Tooltip.init(elements);