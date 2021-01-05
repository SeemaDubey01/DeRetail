/**
 * 
 */
/*
var i = 0;
function billing_addrow(){
    i = i + 1;
    $('#billing-table').append('<tr><td>'+(i+1)+'</td><td><input type="number" size="10" id="sellDetails0.drsdProductCode" name="sellDetails['+i+'].drsdProductCode" value="0"/></td><td><input type="text"  size="30"/></td><td><input type="number" size="4" id="sellDetails0.drsdQuantity" name="sellDetails['+i+'].drsdQuantity" value="0"/></td><td><input type="number" size="12" step="0.01" id="sellDetails0.drsdUnitPrice" name="sellDetails['+i+'].drsdUnitPrice" value="0.0"/></td><td style="width: 120px;"><div class="billing-total" id="billing-total-'+i+'">0</div></td></tr>');
 }
old */
var i = 0;
$(document).ready(function(){
    /* write current date and time on page */ 
    let d = new Date();
    $('#date-today').html('<b>Date :</b>' + d.toDateString() + '   <b>Time:</b> ' + d.toTimeString().substr(0,8));
    
    /* change background color of input boxes */
    inputBgColor();

    /* Calculate total */
    calculateTotalPrice(0);
});
function billing_addrow(){
    i = i + 1;
    $('#billing-table').append('<tr><td>'+(i+1)+'</td><td><input type="number" size="10" id="sellDetails0.drsdProductCode" name="sellDetails['+i+'].drsdProductCode" value="0"/></td><td><input type="text"  size="30"/></td><td><input type="number" size="12" step="0.01" id="sellDetails0.drsdUnitPrice" name="sellDetails['+i+'].drsdUnitPrice" value="0.0"/></td><td><input type="number" size="4" id="sellDetails0.drsdQuantity" name="sellDetails['+i+'].drsdQuantity" value="0"/></td><td style="width: 120px;"><div class="billing-total" id="totalPrice'+i+'">0</div></td></tr>');
      
    inputBgColor();

    /* Calculate total */
    calculateTotalPrice(i);    

	$('input[name="sellDetails['+i+'].drsdProductCode"').focus();
}
function inputBgColor(){
    $('input').focusin(function(){
        $(this).css("background-color","#FFFFCC");
    });
    $('input').focusout(function(){
        $(this).css("background-color","#FFFFFF");
    });
}
function calculateTotalPrice(i){
    let totalPrice = 0;
    $('input[name="sellDetails['+i+'].drsdQuantity"').focusout(function(){
        totalPrice = $('input[name="sellDetails['+i+'].drsdQuantity"').val() * $('input[name="sellDetails['+i+'].drsdUnitPrice"').val();
        $('#totalPrice'+i).text(totalPrice);  
       // console.log('q: ' + $('input[name="sellDetails['+i+'].drsdQuantity"').val() + ' a: ' + $('input[name="sellDetails['+i+'].drsdUnitPrice"').val() + ' i:' +i);  
    });
}
function clearTable(){
    $('#billing-table').html('<tr></td><th>Sr</Src></th><th>Product Code</th><th>Description</th><th>Unit Price</th><th>Quantity</th><th>Total Price</th></tr><tr><td>1</td><td><input type="number" size="10" id="sellDetails0.drsdProductCode" name="sellDetails[0].drsdProductCode" value="0"/></td><td><input type="text"  size="30"/></td><td><input type="number" size="12" step="0.01" id="sellDetails0.drsdUnitPrice" name="sellDetails[0].drsdUnitPrice" value="0.0"/></td><td><input type="number" size="4" id="sellDetails0.drsdQuantity" name="sellDetails[0].drsdQuantity" value="0"/></td><td style="width: 120px;"><div class="billing-total" id="totalPrice0">0</div></td></tr>');
i=0;
}
