let telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
let passwordRegExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합

const goMyPage = (path) => {
	window.location = path + "/account/mypage";
	
}

const goMyPageWithSendData = () => {
	let result = true;
	let memberInfo = {};
	const u_email = $("#u_email").val();
	const u_password = $("#u_password").val();
	const u_re_password = $("#u_re_password").val();
	const u_tel = $("#u_tel").val();
	const u_address = $("#u_address").val();
	const telResult = telRegExp.test(u_tel);
	
	//비밀번호가 공백이면 괜찮습니다. 근데 공백이 아니면 유효성 검사해야 됩니다.
	if(u_password != ""){
		if(u_password != u_re_password){
			alert("비밀번호가 다릅니다.");
			result = false;
			return;		
		} else if(!passwordRegExp.test(u_password)){
			alert("비밀번호 형식이 올바르지 않습니다.");
			result = false;
			return;
		}
	}
	
	if(!telResult){
		alert("전화번호 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(result){
		memberInfo.member_email = u_email;
		memberInfo.member_pw = u_password;
		memberInfo.member_tel = u_tel;
		memberInfo.member_address = u_address;
		
		$.ajax({
			url: "/webapp/account/send-edit-info",
			data: memberInfo,
			method: "post"
		}).then( data => {
			console.log(data.status);
			if(data.status === "success"){
				console.log("성공");
				window.location.href = "/webapp/account/mypage";
			}

		}
		);
	} else{
		console.log("실패");
	}
	
	
}