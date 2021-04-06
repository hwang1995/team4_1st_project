const goCheckedPage = (path) => {
	window.location = path + "/account/mypage";
}

$(function() {
	getList();
});
	
const getList = (pageNo) => {
	const args = {url:"list", method:"get"};
	if(pageNo) {
		args.data = {pageNo};
	}
	console.log("iam ready");
	$.ajax(args).then(data => {
		$("#board").html(data);
	});
};