<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

 <!--회원가입 폼만 적용되는 css-->
    <style type="text/css">
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }
        .join-form {
            margin: 0 auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }            
        .form-group > .sel {
            width: 120px;
            display: inline-block;         
        }
    </style>
    
<section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>회원가입<small>(가운데정렬)</small></h2>

                    <form action="join.user" method="post" name ="user_join">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 (영문포함 4~12자 이상)" required>
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="pw"  id = "pw" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)" required>
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input type="password" class="form-control" name="pwCheck" id = "pwCheck" placeholder="비밀번호를 확인해주세요." required>
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" name="name" placeholder="이름을 입력하세요." required>
                        </div>
                        <!--input2탭의 input-addon을 가져온다 -->
                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input  name="phone1" class="form-control sel" placeholder="010" required> -
                            <input  name="phone2" class="form-control sel" placeholder="xxxx" required> -
                            <input  name="phone3" class="form-control sel" placeholder="xxxx" required>
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input name = email1 class="form-control sel" required>@
                            <select name = "email2" class="form-control sel" required>
                                <option>naver.com</option>
                                <option>gmail.com</option>
                                <option>daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input type="text" name="address1" class="form-control" id="addr-basic" placeholder="기본주소" required>
                        </div>
                        <div class="form-group">
                            <input type="text" name="address2" class="form-control" id="addr-detail" placeholder="상세주소" required>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="join();" >회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='user_login.jsp'">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>       
    </section>
    
  	<script>		
  		function join(){
  			
  			var p1 = document.getElementById('pw').value;
  			var p2 = document.getElementById('pwCheck').value;
  			var id = document.getElementById('id').value;
  			if(p1 == null && p1 != p2){
  				alert("비밀번호 확인란을 확인해주세요.");  				
  			}else if( id == null){
  				alert("id를 입력해주세요.");  
  			}else{
  				user_join.submit(); 				
  			}  			
  		}  	
	</script>

    
<%@ include file="../include/footer.jsp"%>