/**
	login.js는 login에 필요한 프론트 비즈니스 로직을
	선언하기 위한 JS입니다.
*/

//email, password 정규표현식
let emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
let passwordRegExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합

function validate(){
	let result = true;
	const emailElem = $('#user_email').val();
	const passwordElem = $('#user_password').val();
	
	if(!emailElem){
		alert("이메일을 입력해주세요.");
		result = false;
		return;
	} else if(!emailRegExp.test(emailElem)){
		alert("이메일 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(!passwordElem){
		alert("비밀번호를 입력해주세요.");
		result = false;
		return;
	} else if(!passwordRegExp.test(passwordElem)){
		alert("비밀번호 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(result){
		window.location = path;
	} else{
		console.log("로그인 실패");
	}
	
	
};

const goRegisterPage = (path) => {
	window.location = path + "/auth/register";
}