/**
 * 이 JS는 비밀번호 찾기에 필요한 이벤트, 로직, AJAX
 * 등을 구현하기 위해 작성한 JS 입니다.
 * 
 * 구현한 내용은 다음과 같습니다.
 * 1) 이메일, 비밀번호 inputbox에 hover시 popover 구현 (desktop)
 * 2) 이메일, 비밀번호를 입력했는지 점검 (추후 API 서버 만들어지면 구체 구현)
 */

// 전역 변수 (email, pw 정규 표현식)
let emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const pwPattern = "";

// 1) 이메일, 비밀번호 inputbox에 hover시 popover 구현
$('#u_email_desktop').popover({
    trigger : 'hover',
    content : "이메일을 입력해주세요."
});

$('#u_password_desktop').popover({
    trigger : 'hover',
    content : "비밀번호를 입력해주세요."
});

$('.forgot_my_pw_button_mobile').click(() => {
    let infoObj = {};
    infoObj.member_email = $('#u_email_mobile').val();
    infoObj.member_name = $('#u_name_mobile').val();

    // 1 - 이메일이 빈칸인가?
    if(infoObj.member_email === ""){
        alert("이메일이 빈칸입니다.");
        return;
    }

    // 2 - 비밀번호가 빈칸인가?
    if(infoObj.member_name === ""){
        alert("비밀번호가 빈칸입니다.");
        return;
    }

    // 2.1 - 비밀번호가 유효성 검사에 통과되었는가?

    // 3 - 서버로 데이터 넘겨주기

    console.log(infoObj);
});

$('.forgot_my_pw_button_desktop').click(() => {
    let infoObj = {};
    infoObj.member_email = $('#u_email_desktop').val();
    infoObj.member_name = $('#u_name_desktop').val();


    // 1 - 이메일이 빈칸인가?
    if(infoObj.member_email === ""){
        alert("이메일이 빈칸입니다.");
        return;
    }

    // 2 - 비밀번호가 빈칸인가?
    if(infoObj.member_name === ""){
        alert("비밀번호가 빈칸입니다.");
        return;
    }

    // 2.1 - 비밀번호가 유효성 검사에 통과되었는가?
	if(!emailRegExp.test(infoObj.member_email)){
		alert("비밀번호 형식이 올바르지 않습니다.");
		return;
	}

    // 3 - 서버로 데이터 넘겨주기
	$.ajax({
		url: "/webapp/auth/forgot-my-pw",
		data: infoObj,
		method: "post"
	}).then( data => {
		if(data == "success"){
			window.location.href = "/webapp/auth/forgot-my-pw-result";
		} else{
			alert("존재하지 않는 계정 입니다.");
		}
	});

    console.log(infoObj);
});
