$(document).ready(function(){
	checkSearchOption();
});
function checkSearchOption(){
    if ($('#searchCodeRadio').prop('checked')){
        $('#searchCode').prop("disabled", false);
        $('#searchBrand').val(null);
        $('#searchBrand').prop("disabled", true);
        $('#searchName').val(null);
        $('#searchName').prop("disabled", true);
    }
    else {
        if ($('#searchBrandRadio').prop('checked')){
            $('#searchCode').val(null);
            $('#searchCode').prop("disabled", true);
            $('#searchBrand').prop("disabled", false);
            $('#searchName').val(null);
            $('#searchName').prop("disabled", true);
        }
        else {
            $('#searchCode').val(null);
            $('#searchCode').prop("disabled", true);
            $('#searchBrand').val(null);
            $('#searchBrand').prop("disabled", true);
            $('#searchName').prop("disabled", false);
        }
    }
}
function showProductList(){
    $('#productList-div').show();
    $('#productUpdate-div').hide();
    $('#productDisplay-div').hide();
}
function showProductUpdate(index){
	$('#update-productCode').text($('#list-productCode-'+index).text());
    $('#update-brand').val($('#list-brand-'+index).text());
    $('#update-sku').val($('#list-sku-'+index).text());
    $('#update-productName').val($('#list-productName-'+index).text());
    $('#update-productDescr').val($('#list-productDescr-'+index).text());
    
    $('#productList-div').hide();
    $('#productUpdate-div').show();
}
function showProductDisplay(index){
	$('#display-productCode').text($('#list-productCode-'+index).text());
    $('#display-brand').text($('#list-brand-'+index).text());
    $('#display-sku').text($('#list-sku-'+index).text());
    $('#display-productName').text($('#list-productName-'+index).text());
    $('#display-productDescr').text($('#list-productDescr-'+index).text());
  
    $('#productList-div').hide();
    $('#productDisplay-div').show();
    
}
