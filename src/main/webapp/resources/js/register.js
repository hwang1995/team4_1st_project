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
let emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
let telRegExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
let passwordRegExp = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,10}$/; //  8 ~ 10자 영문, 숫자 조합


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
			alert("사용가능한 이메일 입니다.");
		} else{
			alert("사용 불가능한 이메일 입니다.");
		}
	});

});

function validate(){
	//정규표현식
	
	let passwordResult = true;
	let agreementResult = true;
	let memberInfo = {};
	const u_email = $("#u_email").val();
	const u_name = $("#u_name").val();
	const u_password = $("#u_password").val();
	const u_re_password = $("#u_re_password").val();
	const u_tel = $("#u_tel").val();
	const u_address = $("#u_address").val();
	const agreement = $("#agreement").prop("checked");
	const gdpr_agreement = $("#gdpr_agreement").prop("checked");
	const marketing_agreement = $("#marketing_agreement").prop("checked");
	const emailResult = emailRegExp.test(u_email);
	const telResult = telRegExp.test(u_tel);
	const nameResult = true;
	
	if(!emailResult){
		alert("이메일 형식이 올바르지 않습니다.");
		return;
	}
	
	if(u_name == ""){
		alert("이름을 입력해주세요.");
		return;
	}
	
	if(u_password == "" && u_re_password == ""){
		alert("비밀번호를 입력해주세요.");
		passwordResult = false;
		return;
	} else if(u_password != u_re_password){
		alert("비밀번호가 다릅니다.");
		passwordResult = false;
		return;		
	} else if(!passwordRegExp.test(u_password)){
		alert("비밀번호 형식이 올바르지 않습니다.");
		passwordResult = false;
		return;
	}
	
	if(!telResult){
		alert("전화번호 형식이 올바르지 않습니다.");
		return;
	}
	
	
	if(!(agreement && gdpr_agreement && marketing_agreement)){
		alert("약관에 동의해주세요.");
		agreementResult = false;
		return;
	}
	
	if(passwordResult && agreementResult && emailResult && telResult && isEmailChecked){
		memberInfo.member_email = u_email;
		memberInfo.member_name = u_name;
		memberInfo.member_pw = u_password;
		memberInfo.member_tel = u_tel;
		memberInfo.member_address = u_address;
		console.log(memberInfo);
		
		$.ajax({
			url: "/webapp/auth/register",
			data: memberInfo,
			method: "post"
		}).then( data => {
			if(data == "success"){
				window.location.href = "/webapp/auth/welcome";
			}
			console.log(data);
		}
		);
	} else{
		console.log("실패");
	}
	
}



// 4) 회원 가입 구현 로직
// $('.register_confirm_button').click(() => {
//     // 회원 객체 생성 준비
//     let registObj = {};
//     const welcomeUrl = "http://localhost:5500/pages/auth/welcome.html"

//     // JSON 객체 만들기
//     registObj.email = $('#u_email').val();
//     registObj.name = $('#u_name').val();
//     registObj.password = $('#u_password').val();
//     registObj.rePassword = $('#u_re_password').val();
//     registObj.tel = $('#u_tel').val();
//     registObj.address = $('#u_address').val();
//     registObj.agreements = {
//         terms : $('#agreement').prop("checked"),
//         gdpr : $('#gdpr_agreement').prop("checked"),
//         marketing : $('#marketing_agreement').prop("checked")
//     };

//     // 1. E-Mail이 유효한지 점검했는가?
//     if(!isEmailChecked){
//         alert("이메일 CHECK 버튼을 눌러주세요.");
//         return;
//     }

//     // 2. 이름을 입력했는가?
//     if(registObj.name === ""){
//         alert("이름을 입력하세요.");
//         return;
//     }
    
//     // 이 줄에 비밀번호의 유효성 검사를 끝냈는지 점검 if문으로 작성


//     // 3. 비밀번호를 입력했는지 점검 or 비밀번호와 비밀번호 확인이 동일한지 점검
//     if(registObj.password === "") {
//         alert("비밀번호를 입력하세요.");
//         return;
//     } else if (registObj.password !== registObj.rePassword){
//         alert("패스워드가 다릅니다.")
//         return;
//     }

//     // 4. 전화번호의 유효성 검사 및 빈칸 점검 
//     if(registObj.tel === ""){
//         alert("전화번호 칸이 비었습니다.");
//         return;
//     }

//     // 5. 주소를 입력했는가?
//     if(registObj.address === ""){
//         alert("주소칸이 비었습니다.");
//         return;
//     }

//     // 6. 약관에 동의하였는가?
//     if(!registObj.agreement.terms) {
//         alert("약관에 동의해주세요.");
//         return;
//     }

//     $(location).attr('href', welcomeUrl);
    
    
//     console.log(registObj);
// })