/**
 * 이 JS는 회원가입에 필요한 이벤트
 * 로직, AJAX등을 구현하기 위해 작성한
 * JS입니다.
 * 
 * 구현한 내용은 다음과 같습니다.
 * 1) 약관 텍스트에 hover시 popover 구현
 * 2) 약관 모두 동의 checkbox에 클릭 시 모두 선택 구현
 * 3) 이메일 주소가 유효한지 점검 (추후 JSON Parse 하여 로직 결정)
 * 4) 회원 가입 구현 로직
 */

// 전역 변수 (이메일 있는지 체크 여부, email, pw, tel 정규 표현식 작성)
let isEmailChecked = false;
const emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
const passwordRegExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합


/**
 * 1) 약관 텍스트에 hover시 popover 로직
 * 구매회원 이용 약관, 개인 정보 수집, 마케팅 텍스트 hover시
 * 보여줄 텍스트를 정의한 로직
 * - $('.popover_agreement').popover({});
 * - $('.popover_gdpr_agree').popover({});
 * - $('.popover_marketing_agreement').popover({});
 */

$('.popover_agreement').popover({
    trigger : 'hover',
    content : "회원 서비스를 제공하기 위한 동의입니다."
});

$('.popover_gdpr_agree').popover({
    trigger : 'hover',
    content : '회원정보를 수집하여 탈퇴까지 보유합니다.'
});

$('.popover_marketing_agreement').popover({
    trigger : 'hover',
    content : "회원정보로 마케팅에 활용합니다."
});

// 2) 약관 모두 동의 checkbox에 클릭시 모두 선택 로직
$('#all_check').click( () => {
    // 모든 checkbox id의 attributes 속성을 checked로 설정
    const checkboxElem = $('#all_check').prop("checked");

    // 만약 checkboxElem가 클릭시에 true상태라면? true, false -> false
    if(checkboxElem){
        $('#agreement').attr("checked", true);
        $('#gdpr_agreement').attr("checked", true);
        $('#marketing_agreement').attr("checked", true);
    } else {
        $('#agreement').attr("checked", false);
        $('#gdpr_agreement').attr("checked", false);
        $('#marketing_agreement').attr("checked", false);
    }
    
});

// 3) 이메일 주소가 유효한지 점검하는 로직
$('.email_check_button').click(() => {
	
	const u_email = $("#u_email").val();
	const emailResult = emailRegExp.test(u_email);
	
	if(!emailResult){
		alert("올바르지 않은 이메일 주소입니다.")
		return;
	}
	
	const emailInfo = {
		"member_email" : u_email
	};
    
	$.ajax({
		url: "/webapp/auth/existed-email",
		data: emailInfo,
		method: "post"
	}).then(data => {
		if(data == "success"){
			isEmailChecked = true;
			$("#errorUemail").attr("class", "text-success");
			$("#errorUemail").html("사용가능한 이메일 입니다.");
		} else{
			$("#errorUemail").attr("class", "text-danger");
			$("#errorUemail").html("사용 불가능한 이메일 입니다.");
		}
	});

});

function registerValidate(){
	let result = true;
	const memberInfo = {};
	const emailElem = $("#u_email").val();
	const nameElem = $("#u_name").val();
	const passwordElem = $("#u_password").val();
	const rePasswordElem = $("#u_re_password").val();
	const telElem = $("#u_tel").val();
	const addressElem = $("#u_address").val();
	const agreement = $("#agreement").prop("checked");
	const gdpr_agreement = $("#gdpr_agreement").prop("checked");
	const marketing_agreement = $("#marketing_agreement").prop("checked");
	
	if(!emailElem){
		alert("이메일을 입력해주세요.");
		result = false;
		return;
	} else if(!emailRegExp.test(emailElem)){
		alert("이메일 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(!nameElem){
		alert("이름을 입력해주세요.");
		result = false;
		return;
	}
	
	if(!passwordElem && !rePasswordElem){
		alert("비밀번호를 입력해주세요.");
		result = false;
		return;
	} else if(passwordElem != rePasswordElem){
		alert("비밀번호가 다릅니다.");
		result = false;
		return;		
	} else if(!passwordRegExp.test(passwordElem)){
		alert("비밀번호 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
	
	if(!telElem){
		alert("전화번호를 입력해주세요.");
		result = false;
		return;
	} else if(!telRegExp.test(telElem)){
		alert("전화번호 형식이 올바르지 않습니다.");
		result = false;
		return;
	}
		
	
	if(!addressElem){
		alert("주소를 입력해주세요.");
		result = false;
		return;
	}
	
	if(!(agreement && gdpr_agreement && marketing_agreement)){
		alert("약관에 동의해주세요.");
		result = false;
		return;
	}
	
	if(result){
		memberInfo.member_email = emailElem;
		memberInfo.member_name = nameElem;
		memberInfo.member_pw = passwordElem;
		memberInfo.member_tel = telElem;
		memberInfo.member_address = addressElem;
		
		$.ajax({
			url: "/webapp/auth/register",
			data: memberInfo,
			method: "post"
		}).then( data => {
			if(data == "success"){
				window.location.href = "/webapp/auth/welcome";
			}
		}
		);
	} else{
		console.log("실패");
	}
	
}