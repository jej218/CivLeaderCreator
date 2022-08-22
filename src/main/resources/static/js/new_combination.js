/**
 * 
 */
 
M.AutoInit();
document.addEventListener('DOMContentLoaded', function() {
	var elems = document.querySelectorAll('select');
	var outerColorOptions = elems[2].options;
	var innerColorOptions = elems[3].options;
	var outerColorInstance = M.FormSelect.getInstance(elems[2]);
	var innerColorInstance = M.FormSelect.getInstance(elems[3]);
	var outerColorWrapper = outerColorInstance.dropdownOptions;
	var innerColorWrapper = innerColorInstance.dropdownOptions;
	var outerColorWrappers = outerColorWrapper.getElementsByTagName("li");
	var innerColorWrappers = innerColorWrapper.getElementsByTagName("li");
	for (let i = 0; i < outerColorWrappers.length; i++) {
	  outerColorWrappers.item(i).style.backgroundColor = '#' + outerColorOptions.item(i).value;
	  innerColorWrappers.item(i).style.backgroundColor = '#' + innerColorOptions.item(i).value;
	}

});
