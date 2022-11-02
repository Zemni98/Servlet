
function myFunc(){
	// alert("Click!!");
	
	// JQurey 사용!!
	// 1. 내가 원하는 Element를 찾아서 JQuery객체로 변환!!
	//	 HTML Element를 referencing하는 jQuery객체를 생성해 보자!
	// 	 selector를 이용하자!!
	// 	 1-1. 전체 선택자 (universial selector)
	// 	 	 내가 원하는 selector를 문자열 형태로 삽입 $()
	// 	 	 "*" HTML에 있는 모든 Element를 지칭한다.
			// $("*").css("color","blue");
			
	//	 1-2. 태그 선택자 (tag selector)
			// alert($("div").text()); // Element 사이에 있는 문자열을 들고오는 Method
	//	 1-2.1
			// $("div").text("수민이 보고싶다."); // tag 사이에 있는 문자열을 바꾼다.
			
	//	 1-3 아이디 선택자 (ID selector)
	//		 기호로 "#"
			// $("#myH1").text("zz");
			// $("#myH1").remove();
			
	//	 1-4 클래스 선택자 (Class selector)
	//		 기호로 "."
	//		 더불어서 block-level element와 inline element에 대해서도 알아보았다.
			// $(".haha").css("background-color", "yellow");
			// $(".lala").css("background-color", "yellow");
	
	// 	 1-5 구조 선택자 ()
	//		 기호로 " "(후손선택자) 공백
	// $("div li").css("color","blue");
	//		 기호로 ">" (자식선택자)
	// $("ul.myclass > li").css("color","red");
	//	 1-5.1 형제 선택자
	//		 기호로 "+" 바로 다음에 나오는 형제 하나
	// $("#seoul + li").css("color","blue");
	//		 기호로 "~" 다음에 나오는 형제 싹~ 다!!
	// $("#seoul ~ li").css("color","blue");
	
	// 	 1-6 특수 선택자
	//		 기호로 : first,second,last => 순번 영어로
	// $("ul.myclass > li:first + li").css("color","red");
	// $("ul.myclass > li:last").css("color","red");
	// $("ul.myclass > li:nth-child(1)").css("color","red"); // 1,2,3 순번
	
	// 	 1-7 속성 선택자
	//  	 기호로 "[ ]"
	// alert($("[size = 30]").css("color","red").val("값 변경도 가능한다."))
	// [size = 10] 값까지 매칭시킬 수 있다.
	// val() => 사용자가 입력한 값 얻어오기
	// val("값 변경도 가능!!") => 안에 있는 값도 변경할 수 있다.
}