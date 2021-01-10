/**
 * 
 */
function checkData(iBillNo, isError){
	$('#errormsg').hide();
	if (iBillNo == 0){
		$('#search-result').hide();
		if(isError == 'true'){
			$('#errormsg').show();
		}
	}

	$('#cashier').text(sessionStorage.getItem("myuser"));
}