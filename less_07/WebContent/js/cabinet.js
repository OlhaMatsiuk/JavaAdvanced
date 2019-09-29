var products = null;

$.get("products", function(data) {
	if (data !== '') {
		products = data;
	}
}).done(function() {
	
	var cardsContent = "";
	jQuery.each(products, function(i, value) {
	
		cardsContent+="<div class='col'>" +
					  "<div class='card'>" +
					  "<div class='card-body'>" +
					  "<h5 class='card-title'>" + value.title + "</h5>"+
					  "<p class='card-text'>" + value.category + "</p>"+
					  "<p class='card-number'>" + value.publish_date + "</p>"+
					  "<h6 class='card-subtitle mb-2 text-muted'>" + value.price + "</h6>"+
					  "<a href='product?id=" + value.id + "' class='card-link'>Details</a>"+
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>"
	});
	
	  $('#productCards').html(cardsContent);
	
});