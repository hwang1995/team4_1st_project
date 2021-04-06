//전화번호와 비밀번호 정규표현식
let telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
let passwordRegExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합

//mypage로 돌아감.
const goMyPage = (path) => {
	window.location = path + "/account/mypage";
}

//edit-my-info 정보를 보내줌.
const goMyPageWithSendData = () => {
	let result = true;   //유효성 검사가 다 통과되었는지 확인하기 위한 변수
	const u_password = $("#u_password").val();
	const u_re_password = $("#u_re_password").val();
	const u_tel = $("#u_tel").val();
	const u_address = $("#u_address").val();
	
	if(u_password != u_re_password){
		alert("비밀번호가 다릅니다.");
		result = false;
		return;		
	}
	//비밀번호가 공백이면 괜찮습니다. 근데 공백이 아니면 유효성 검사해야 됩니다.
	if(u_password != "" && !passwordRegExp.test(u_password)){
		alert("비밀번호 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(!telRegExp.test(u_tel)){
		alert("전화번호 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(u_address == ""){
		alert("주소를 입력해주세요.");
		result = false;
		return;
	}
	
	if(result){
		let memberInfo = {};
		const u_email = $("#u_email").val();
		memberInfo.member_email = u_email;
		memberInfo.member_pw = u_password;
		memberInfo.member_tel = u_tel;
		memberInfo.member_address = u_address;
		
		$.ajax({
			url: "/webapp/account/send-edit-info",
			data: memberInfo,
			method: "post"
		}).then(data => {
			if(data.status === "success"){
				alert("회원정보가 수정되었습니다.");
				window.location.href = "/webapp/account/mypage";
			}
		});
	} else{
		alert("오류가 발생했습니다.");
	}
}