/*
*  maincategory와 subcategry에 따라 order의 queryString 변경
*/
$(function() {
   $('#item_select').change(function() {
     if(this.value === "high") {
		   var qsList=window.location.href.split('?');
		   if(typeof(qsList[1]) != "undefined" && qsList[1].includes("subcategory")) {
		      window.location.href = window.location.href.split('&')[0] + "&order=high";
		   }else{
		      window.location.href = window.location.href.split('?')[0] + "?order=high";
		   }
    }else if(this.value ==="low") {
            var qsList=window.location.href.split('?');
		   if(typeof(qsList[1]) != "undefined" && qsList[1].includes("subcategory")) {
		      window.location.href = window.location.href.split('&')[0] + "&order=low";
		   }else{
		      window.location.href = window.location.href.split('?')[0] + "?order=low";
		   }
         }
   })
});
  

const goProductDetailPage = (path, product_id) => {
	window.location.href = path + "/product/" + product_id;
}
   