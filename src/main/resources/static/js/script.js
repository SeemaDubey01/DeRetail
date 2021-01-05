/**
 * 
 */
 $(document).ready(function(){
    /* write current date and time on page */ 
    let d = new Date();
    $('#date-today').html('<b>Date :</b>' + d.toDateString() + '   <b>Time:</b> ' + d.toTimeString().substr(0,8));
  
 });
 