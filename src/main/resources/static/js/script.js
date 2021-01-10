/**
 * 
 */
 $(document).ready(function(){
    /* write current date and time on page */ 
    let d = new Date();
    $('#date-today').html('<b>Date :</b>' + d.toDateString() + '   <b>Time:</b> ' + d.toTimeString().substr(0,8));
  	putUserName();
 });
 function putUserName(){
	 if (typeof(Storage) !== "undefined") {
		myuser = sessionStorage.getItem("myuser");
		$('#username').text(myuser);
	}
}
 