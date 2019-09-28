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