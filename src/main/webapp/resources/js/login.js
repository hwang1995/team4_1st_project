/**
	login.js는 login에 필요한 프론트 비즈니스 로직을
	선언하기 위한 JS입니다.
*/

//email 정규표현식
const emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

function loginValidate(){
	const emailElem = $('#user_email').val();
	const passwordElem = $('#user_password').val();
	
	if(!emailElem){
		alert("이메일을 입력해주세요.");
		return;
	} else if(!emailRegExp.test(emailElem)){
		alert("이메일 형식이 올바르지 않습니다.");
		return;
	}
	
	if(!passwordElem){
		alert("비밀번호를 입력해주세요.");
		return;
	}

};

const goRegisterPage = (path) => {
	window.location = path + "/auth/register";
}