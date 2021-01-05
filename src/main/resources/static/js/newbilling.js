var index = 0;
var totalBill = 0;
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
    index = index + 1;
    $('#billing-table').append('<tr><td>'+(index+1)+'</td><td><input type="number" size="10" id="sellDetails0.drsdProductCode" name="sellDetails['+index+'].drsdProductCode" value="0"/></td><td><input type="text"  size="30"/></td><td><input type="number" size="12" step="0.01" id="sellDetails0.drsdUnitPrice" name="sellDetails['+index+'].drsdUnitPrice" value="0.0"/></td><td><input type="number" size="4" id="sellDetails0.drsdQuantity" name="sellDetails['+index+'].drsdQuantity" value="0"/></td><td style="width: 120px;"><div class="billing-total" id="totalPrice'+index+'">0</div></td></tr>');
      
    inputBgColor();

    /* Calculate total */
    calculateTotalPrice(index);    

    $('input[name="sellDetails['+index+'].drsdProductCode"').focus();
}
function inputBgColor(){
    $('input').focusin(function(){
        $(this).css("background-color","#FFFFCC");
    });
    $('input').focusout(function(){
        $(this).css("background-color","#FFFFFF");
    });
    $('input').focus(function(){$(this).select();})
}
function calculateTotalPrice(index){
    let totalPrice = 0;
    $('input[name="sellDetails['+index+'].drsdQuantity"').focusout(function(){
        totalPrice = $('input[name="sellDetails['+index+'].drsdQuantity"').val() * $('input[name="sellDetails['+index+'].drsdUnitPrice"').val();
        $('#totalPrice'+index).text(totalPrice.toFixed(2));  
        updateTotalBill();
        //console.log('q: ' + $('input[name="sellDetails['+index+'].drsdQuantity"').val() + ' a: ' + $('input[name="sellDetails['+index+'].drsdUnitPrice"').val() + ' index:' +index);  
    });
    
    
    //console.log("total bill is: " + totalBill + " and price is: " + totalPrice);
}
function clearTable(){
    $('#billing-table').html('<tr></td><th>Sr</Src></th><th>Product Code</th><th>Description</th><th>Unit Price</th><th>Quantity</th><th>Total Price</th></tr><tr><td>1</td><td><input type="number" size="10" id="sellDetails0.drsdProductCode" name="sellDetails[0].drsdProductCode" value="0"/></td><td><input type="text"  size="30"/></td><td><input type="number" size="12" step="0.01" id="sellDetails0.drsdUnitPrice" name="sellDetails[0].drsdUnitPrice" value="0.0"/></td><td><input type="number" size="4" id="sellDetails0.drsdQuantity" name="sellDetails[0].drsdQuantity" value="0"/></td><td style="width: 120px;"><div class="billing-total" id="totalPrice0">0</div></td></tr>');
    index=0;
    totalBill = 0;
    $('#totalBill').text(totalBill);
    inputBgColor();
    calculateTotalPrice(index);
    $('input[name="sellDetails['+index+'].drsdProductCode"').focus();
}
function updateTotalBill(){
    var totalBill = 0.00;
    //console.log("index: " + index + " price: " + $('#totalPrice'+index).text());
    for (i = 0; i<=index;i++){
        totalBill = totalBill + parseFloat($('#totalPrice'+i).text());  
    }
    $('#totalBill').text(totalBill);    
}