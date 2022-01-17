<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 페이지</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/sign/join.css">

</head>
<body>
   <div class="container">
      <div class="input-form-backgroud row">
         <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">회원가입</h4>
            <form action="/view/sign/join" method="post" class="validation-form" novalidate >
               <div class="row">
                  <div class="col-md-6 mb-3">
                     <label for="name">이름</label> <input type="text"
                        class="form-control" name="name" placeholder="" value="" required>
                     <div class="invalid-feedback">이름을 입력해주세요.</div>
                  </div>
                  <div class="col-md-6 mb-3">
                     <label for="studenID">학번</label> <input type="text"
                        class="form-control" name="studentID" placeholder="" value=""
                        required>
                     <div class="invalid-feedback">학번을 입력해주세요.</div>
                  </div>
               </div>
               <div class="mb-3">
                  <label for="password">비밀번호</label> <input type="password"
                     class="form-control" name="password" placeholder="비밀번호를 입력해주세요."
                     required>
                  <div class="invalid-feedback">비밀번호를 입력해주세요.</div>
               </div>
               <div class="mb-3">
                  <label for="department">학과</label> <input type="text"
                     class="form-control" name="department" placeholder="학과를 입력해주세요."
                     required>
                  <div class="invalid-feedback">학과을 입력해주세요.</div>
               </div>
               <div class="mb-3">
                  <label for="email">이메일</label> <input type="email"
                     class="form-control" name="email" placeholder="you@example.com"
                     required>
                  <div class="invalid-feedback">이메일을 입력해주세요.</div>
               </div>
               <div class="mb-3">
                  <label for="address">주소</label> <input type="text"
                     class="form-control" name="address" placeholder="서울특별시 강남구"
                     required>
                  <div class="invalid-feedback">주소를 입력해주세요.</div>
               </div>
               <div class="mb-3">
                  <label for="detailAddress">상세주소<span class="text-muted">&nbsp;
                  </span></label> <input type="text" class="form-control" name="detailAddress"
                     placeholder="상세주소를 입력해주세요.">
                <div class="mb-3">
                <div>
                  <label for="motive">지원동기</label> <input type="text"
                     class="form-control" name="motive" placeholder="지원동기를 입력해주세요."
                     required>
                  <div class="invalid-feedback">지원동기을 입력해주세요.</div>
               </div>
               </div>
               </div>
               <input type="hidden" name="authority" value="0">
               <!-- <div class="row">
                  <div class="col-md-8 mb-3">
                     <label for="root">가입 경로</label> <select
                        class="custom-select d-block w-100" id="root">
                        <option value=""></option>
                        <option>어플</option>
                        <option>지인 소개</option>
                        <option>검색</option>
                     </select>
                     <div class="invalid-feedback">가입 경로를 선택해주세요.</div>
                  </div>
               </div> -->
               <hr class="mb-4">
               <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" id="aggrement"
                     required> <label class="custom-control-label"
                     for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
               </div>
               <div class="mb-4"></div>
               <button class="btn btn-danger btn-lg btn-block" type="submit">
                  가입완료
               </button>
            </form>
         </div>
      </div>
      <footer class="my-3 text-center text-small">
         <p class="mb-1">&copy; 2021년 08월 29일</p>
      </footer>
   </div>
   <script> window.addEventListener('load', () => { const forms = document.getElementsByClassName('validation-form'); Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) { if (form.checkValidity() === false) { event.preventDefault(); event.stopPropagation(); } form.classList.add('was-validated'); }, false); }); }, false); </script>
</body>
</html>