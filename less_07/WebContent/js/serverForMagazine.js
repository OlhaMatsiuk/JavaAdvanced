$("button.createProduct").click(function() {

	var name = $("form.createProduct input.productName").val();
	var category = $("form.createProduct input.productCategory").val();
	var price = $("form.createProduct input.productPrice").val();
	var publishDate = $("form.createProduct input.productDate").val();

	var product = {
		name : name,
		category : category,
		price : price,
		publishDate : publishDate
	};

	$.post("product", product, function(data) {
		$("form").reset();
	});

});

$("button.buy-product").click(function() {
	var productId = jQuery(this).attr("product-id");
	
	
	$.post("bucket", {'productId':productId},
			function(data) {
				if (data == 'Success') {
			//		$('#buyProductModal').hide();
					$("[data-dismiss=modal]").trigger({type:"click"});
					alert('Success');
				}
			});
});