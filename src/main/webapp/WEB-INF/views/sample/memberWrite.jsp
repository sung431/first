<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
</head>
<body>
    <form id="frm" action="<c:url value='/sample/insertMember.do' />" method="POST">
    <input type="hidden" id="dno" name="dno" value="7"/>
        <table class="board_view">
            <colgroup>
                <col width="15%">
                <col width="*"/>
            </colgroup>
            <caption>사원등록</caption>
            <tbody>
                <tr>
                    <th scope="row">이름</th>
                    <td><input type="text" id="mname" name="mname" class="wdp_90"></input></td>
                </tr>
            </tbody>
        </table>
         
        <a href="#this" class="btn" id="write" >작성하기</a>
        <a href="#this" class="btn" id="list" >목록으로</a>
    </form>
     
    <%@ include file="/WEB-INF/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
        	
			$("#list").on("click", function(e){
				e.preventDefault();
				fn_openMemberList();
			});
			
			$("#write").on("click", function(e){ //작성하기 버튼
		        e.preventDefault();
		        $("#frm").submit();
		    });

        });
        
        function fn_openMemberList(){
        	var comSubmit = new ComSubmit();
        	comSubmit.setUrl("<c:url value='/sample/openMemberList.do' />");
        }
        
        function fn_insertMember(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("<c:url value='/sample/insertMember.do' />");
            comSubmit.submit();
        }

    </script>
</body>
</html>