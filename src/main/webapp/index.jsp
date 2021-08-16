<%@page isELIgnored="false"%>
<html>
<head>
<title>Add images</title>
<style>
body {
	background: #03a9f455;
}

.container {
	margin: auto;
	font-family: Calibri, Helvetica, Times New Roman;
	font-size: large;
	padding: 30px;
	border-radius: 5px;
	width: 30%;
	background: rgba(255, 255, 255, 0.2);
	box-shadow: 0 5px 45px rgba(0, 0, 0, 0.15);
}

label {
	color: black;
	font-weight: bold;
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=text], [type=number], [type=file] {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
	font-size: large;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

input[type=submit] {
	margin-top: 15px;
	background: #03a9f4;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: large;
}

.smallheading {
	margin-top: 1px;
	text-align: center;
	font-family: cursive;
	color: #333;
}
/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 5px;
	}
}
</style>
</head>
<body>
	<form action="InsertImage" method="post" enctype="multipart/form-data">
		<h2 class="smallheading" style="margin-top: 12vh;">Insert image
			in database using Spring MVC</h2>
		<div class="container">
			<div class="row">
				<h2 class="smallheading">${msg }</h2>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="id">Flower ID</label>
				</div>
				<div class="col-75">
					<input type="number" name="id" id="id" />
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="name">Flower Name</label>
				</div>
				<div class="col-75">
					<input type="text" name="name" id="name" />
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="photo">Flower Photo</label>
				</div>
				<div class="col-75">
					<input type="file" name="photo" id="photo" />
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<input type="submit" id="log" />
				</div>
				<div class="col-75">
					<input type="submit" value="Show all"
						onclick="javascript: form.action='fetch';" />
				</div>
			</div>
			<div class="row"></div>
		</div>

	</form>
</body>
</html>