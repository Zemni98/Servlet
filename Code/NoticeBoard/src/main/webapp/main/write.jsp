<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>

<title>Checkout example · Bootstrap v5.2</title>


<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">


<style>
}
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>


<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container">
		<main>
			<div class="col-md-7 col-lg-8">
				<br>
				<br>
				<h4 class="mb-3">게시글 쓰기</h4>
				<form class="needs-validation" novalidate>
					<div class="row g-3">
						<div class="col-sm-6">
							<label for="firstName" class="form-label">글 제목</label> <input
								type="text" class="form-control" id="postTitle"
								placeholder="제목을 작성하세요." required> <br>
						</div>
					</div>
				</form>
			</div>
		</main>
	</div>




	<div class="container">
		<div class="row">
			<form action="/NoticeBoard/main/writeAction.jsp" method="POST">



				<label for="firstName" class="form-label">내용</label>
				<textarea class="form-control" placeholder="글 내용" id="postContent"
					maxlength="2048" style="width: 800px; height: 350px"></textarea>
				<br>

				<button class="w-50 btn btn-lg  btn-primary" type="submit">글
					쓰기</button>

			</form>
		</div>
	</div>




	<footer class="my-5 pt-5 text-muted text-center text-small">
		<p class="mb-1">&copy; ZEM_NI98</p>
	</footer>

</body>
</html>
