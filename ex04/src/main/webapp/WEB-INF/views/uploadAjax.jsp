<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.fileDrop {
	width: 100%;
	height: 200px;
	border: 1px dotted blue;
}
small {
	margin-left: 3px;
	font-weight: bold;
	color: gray;
}
</style>
</head>
<body>

	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>
	
	<div class="uploadedList"></div>
	
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		//해당부분에 드레그한 요소가 들어가거나 해당부분 위에 있을 경우
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();	//기본 이벤트 방지(새창 열기)
		});
		
		//해당부분에 드레그한 요소를 놓았을 경우
		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();	//기본 이벤트 방지(새창 열기)
			
			var originalEvent = event.originalEvent;	//순수한 DOM 이벤트를 획득
			var files = originalEvent.dataTransfer.files;	//이벤트 발생 시 전달된 데이터 속 파일 정보 획득
			
			var file = files[0];
			
			//console.log(file);
			var formData = new FormData();	//Form태그 전송 방식과 동일한 전송을 지원해주는 객체(HTML5)
			
			formData.append("file", file);
			
			$.ajax({
				url: "/uploadAjax",
				data: formData,
				dataType: "text",
				processData: false,	//데이터를 일반적인 쿼리 문자열로 변환 할지를 결정
				contentType: false,	//기본값이 application / x-www-form-urlencoded이므로 false사용
				type: "POST",
				success: function(data) {
					var str = "";
					
					console.log(data);
					console.log(checkImageType(data));
					
					if(checkImageType(data)) {
						str = "<div>"
								+ "<a href='displayFile?fileName=" + getImageLink(data) + "'>"
								+ "<img src='displayFile?fileName=" + data + "'/>" + getImageLink(data) + "</a></div>";
					} else {
						str = "<div><a href='displayFile?fileName=" + data + "'>"
								+ getOriginalName(data) + "</a></div>";
					}
					$(".uploadedList").append(str);
				}
			});
		});
		
		function checkImageType(fileName) {
			var pattern = /jpg|gif|png|jpeg/i;	//확장자 패턴 정규표현식, i는 대소문자 구분 없음을 의미
			
			return fileName.match(pattern);
		}
		
		//저장된 파일 이름에서 저장 시 지정한 파일이름을 추출하여 반환
		function getOriginalName(fileName) {
			if(checkImageType(fileName)) {
				return;
			}
			
			var idx = fileName.indexOf("_") + 1;
			return fileName.substr(idx);
		}
		
		//썸네일 파일 이름에서 저장된 원본파일 이름을 추출하여 반환
		function getImageLink(fileName) {
			if(!checkImageType(fileName)) {
				return;
			}
			
			var front = fileName.substr(0, 12);
			var end = fileName.substr(14);
			
			return front + end;
		}
	</script>

</body>
</html>