
function search(){
	
	let keyword = $("#searchKeyword").val();
	let requestURL = "http://localhost:8080/book/bsearch" + "?keyword=" + keyword;
	window.location.href = requestURL;
}