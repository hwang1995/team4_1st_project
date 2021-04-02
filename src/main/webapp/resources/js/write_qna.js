const getQnaData = (path) => {
	let result = true;
	const qnaObj = {};
	const categoryElem = $('#category_select').val();
	const titleElem = $('#title').val();
	const contentElem = $('#content_area').val();
	qnaObj.qna_category = categoryElem;
	qnaObj.qna_title = titleElem;
	qnaObj.qna_content = contentElem;
	
	if(!categoryElem){
		alert("카테고리를 선택해주세요.");
		result = false;
		return;
	}
	
	if(!titleElem){
		alert("제목을 입력해주세요.");
		result = false;
		return;
	}
	
	if(!contentElem){
		alert("내용을 입력해주세요.");
		result = false;
		return;
	}
	
	if(result){
		$.ajax({
			url: "/webapp/qna/write",
			data: qnaObj,
			method: "post"
		}).then( data => {
			if(data == "success"){
				console.log("성공");
				window.location.href = "/webapp/qna/result";
			}
		}
		);
	} else{
		console.log("실패");
	}
	
	
	
}