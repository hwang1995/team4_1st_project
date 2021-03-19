const getQnaData = (path) => {
	const qnaObj = {};
	const categoryElem = $('#category_select').val();
	const titleElem = $('#title').val();
	const contentElem = $('#content_area').val();
	qnaObj.category = categoryElem;
	qnaObj.title = titleElem;
	qnaObj.content = contentElem;
	console.log(qnaObj);
	window.location.href = path + "/qna/result";


}