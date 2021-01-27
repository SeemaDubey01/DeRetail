/**
 * 
 */
var wsSellList;
function validateSearch(){
    if($('#sbillNo').val() == ''){
         $('#sbillNo').val(0);
    }      
    
    var now = new Date();
 	var today = now.getFullYear() + "-" + ("0" + (now.getMonth() + 1)).slice(-2) + "-" + ("0" + now.getDate()).slice(-2) ;

    if($('#sstartDate').val() == ''){
         $('#sstartDate').val(today);
    }  
    if($('#sendDate').val() == ''){
         $('#sendDate').val(today);
    }  
}
function showSellDetails(sell){
	$('#dBillNo').text(wsSellList[sell].billNo);
	var d = new Date(wsSellList[sell].dateSold);
	$('#dDate').html('<b>Date :</b> ' + d.toDateString() + '   <b>Time:</b> ' + d.toTimeString().substr(0,8));
	var html = '<tbody><tr class="table-light"><th>#</th><th>Description</th><th>Unit Price</th><th>Qty</th><th>Total Price</th></tr>';
	$('#search-detail-table').html(html);
	wsSellList[sell].sellDetails.forEach(function (item, index){
		html = '<tr><td>' + item.itemNo + '</td><td>' + item.productDescr + '</td><td>' + item.unitPrice + '</td><td>' + item.quantity + '</td><td>' + item.totalPrice + '</td></tr>';
		$('#search-detail-table').append(html);
	});
	$('#search-detail-table').append('</tbody>');
	$('#totalBill').text(wsSellList[sell].totalBill);
	$('#payable').text(wsSellList[sell].totalBill);
	
    $('#sell-header-div').hide();
    $('#sell-detail-div').show();
}
function showSellHeader(){
    $('#sell-header-div').show();
    $('#sell-detail-div').hide();
}
/*
	private int itemNo;
	private int productCode;
	private String productDescr;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
*/