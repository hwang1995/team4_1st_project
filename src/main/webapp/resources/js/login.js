/**
	login.js는 login에 필요한 프론트 비즈니스 로직을
	선언하기 위한 JS입니다.
*/

const goHomePage = (path) => {
	window.location = path;
};

const goRegisterPage = (path) => {
	window.location = path + "/auth/register";
}