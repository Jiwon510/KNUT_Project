<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!DOCTYPE html>
<html lnag="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
        <link rel="stylesheet" href="/VIEW/join/css/join.css">
        <!-- <script src="main.jsp"></script> -->
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        
    </head>
    <body>
        <!-- header -->
        <div id="header">
            <a href="VIEW/login/login.jsp" ><img src="/VIEW/join/images/header-logo2.jpg" id="logo"></a>
        </div>

		
        <!-- wrapper -->
        <div id="wrapper">
			<form action="/VIEW/join/join" method="post" >
            <!-- content-->
            <div id="content">

                
                <!-- NAME -->
                <div>
                  <h3 class="join_title"><label for="name">이름</label></h3>
                  <span class="box int_name">
                      <input type="text" name="name" id="name" class="int" maxlength="20">
                  </span>
                  <span class="error_next_box"></span>
                </div>

                <!-- ID -->
                <div>
                    <h3 class="join_title">
                        <label for="studenID">학번</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" name="studentID" id="id" class="int" maxlength="20">
                        
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="password">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" name="password" id="pswd1" class="int" maxlength="20">
                        <span id="alertTxt">사용불가</span>
                        <img src="/VIEW/join/images/unlock2.jpg" id="pswd1_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW2 -->
                <div>
                    <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                    <span class="box int_pass_check">
                        <input type="password" id="pswd2" class="int" maxlength="20">
                        <img src="/VIEW/join/images/unlock2.jpg" id="pswd2_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="name">학과</label></h3>
                    <span class="box int_name">
                        <input type="text" id="name" name="department" class="int" maxlength="20">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- BIRTH -->
                <div>
                    <h3 class="join_title"><label for="yy">생년월일</label></h3>

                    <div id="bir_wrap">
                        <!-- BIRTH_YY -->
                        <div id="bir_yy">
                            <span class="box">
                                <input type="text" id="yy" class="int" maxlength="4" placeholder="년(4자)">
                            </span>
                        </div>

                        <!-- BIRTH_MM -->
                        <div id="bir_mm">
                            <span class="box">
                                <select id="mm" class="sel">
                                    <option>월</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>                                    
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </span>
                        </div>

                        <!-- BIRTH_DD -->
                        <div id="bir_dd">
                            <span class="box">
                                <input type="text" id="dd" class="int" maxlength="2" placeholder="일">
                            </span>
                        </div>

                    </div>
                    <span class="error_next_box"></span>    
                </div>

                <!-- GENDER -->
                <div>
                    <h3 class="join_title"><label for="gender">성별</label></h3>
                    <span class="box gender_code">
                        <select id="gender" class="sel">
                            <option>성별</option>
                            <option value="M">남자</option>
                            <option value="F">여자</option>
                        </select>                            
                    </span>
                    <span class="error_next_box">필수 정보입니다.</span>
                </div>

                <!-- EMAIL -->
                <div class="email-wrap">
                    <div id="email-box">
                      <h3 class="join_title"><label for="email">이메일<span class="optional" name="email" ></span></label></h3>
                      <span class="box int_email">
                          <input type="text" name="email" id="email" class="int" maxlength="100" >
                      </span>
                    </div>
                    <p>@</p>
                    <div id="email-box">
                      <span class="box int_email">
                        <select id="domain">
                          <option value="">선택</option>
                          <option value="1">직접입력</option>
                          <option value="naver">naver.com</option>
                          <option value="knut">a.ut.ac.kr</option>
                          <option value="google">gmail.com</option>
                          <option value="daum">daum.net</option>
                        </select>

                        <!-- <script>
                          (function() {
                              ('domain').change(function() {
                                  if (('#domain').val() == '1') {
                                      ('#domainName').attr("disabled", false);
                                      ('#domainName').val("");
                                      ('#domainName').focus();
                                  } else {
                                      ('#domainName').val(('#select').val());
                                  }
                              })
                          });
                        </script>  -->
                       
                      </span>
                    </div>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>

                <!-- MOBILE -->
                <div>
                    <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                    <span class="box int_mobile">
                        <input type="tel" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
                    </span>
                    <span class="error_next_box"></span>    
                </div>

                <!-- address -->
                <div>
                  <h3 class="join_title2">주소</h3>
                  <input id="member_post"  type="button" value='주소찾기' readonly onclick= "findAddr();">
                  
            
                  <span class="box int_address">
                    <input type="text" class="form-control" id="address"  name="address" ><br>
                    

                  </span>
                </div>

                <div>
                  <h3 class="join_title">상세 주소</h3>

                  <span class="box int_address">
                    <input type="text" class="form-control" id="address"  name="detailAddress" ><br>
                    

                  </span>
                </div>

                <div>
                  <h3 class="join_title">지원 동기</h3>

                  <span class="box_int_motivation">
                    <input type="text" class="form-control" name="motive" id="motivation" ><br>
                    

                  </span>
                </div>
                
                <!-- 권한 -->
                <input type="hidden" name="authority" value="0">


                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="submit" id="btnJoin">
                        <span>가입하기</span>
                    </button>
                </div>
                </form>

                

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
    <!-- <script src="main.jsp"></script> -->
    </body>
</html>


                        
<script>
/* (function() {
    ('#domain').change(function() {
        if (('#domain').val() == '1') {
            ('#domainName').attr("disabled", false);
            ('#domainName').val("");
            ('#domainName').focus();
        } else {
            ('#domainName').val(('#select').val());
        }
    })
}); */

/*변수 선언*/


var id = document.querySelector('#id');

var pw1 = document.querySelector('#pswd1');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#pswd1_img1');

var pw2 = document.querySelector('#pswd2');
var pwImg2 = document.querySelector('#pswd2_img1');
var pwMsgArea = document.querySelector('.int_pass');

var userName = document.querySelector('#name');

var yy = document.querySelector('#yy');
var mm = document.querySelector('#mm');
var dd = document.querySelector('#dd');

var gender = document.querySelector('#gender');

var email = document.querySelector('#email');

var mobile = document.querySelector('#mobile');

var error = document.querySelectorAll('.error_next_box');



/*이벤트 핸들러 연결*/


id.addEventListener("focusout", checkId);
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
yy.addEventListener("focusout", isBirthCompleted);
mm.addEventListener("focusout", isBirthCompleted);
dd.addEventListener("focusout", isBirthCompleted);
gender.addEventListener("focusout", function() {
    if(gender.value === "성별") {
        error[5].style.display = "block";
    } else {
        error[5].style.display = "none";
    }
})
email.addEventListener("focusout", isEmailCorrect);
mobile.addEventListener("focusout", checkPhoneNum);

/*콜백 함수*/


function checkId() {
    var idPattern = /[0-9]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "숫자만 사용 가능합니다.";
        error[0].style.display = "block";
    } else {
        error[0].innerHTML = "사용가능합니다!";
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
    }
}

function checkPw() {
    var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pw1.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        error[1].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[1].style.display = "block";
        
        pwMsg.style.display = "block";
        pwImg1.src = "/VIEW/join/iamges/lock2.jpg";
    } else {
        error[1].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "/VIEW/join/iamges/lock2.jpg";
    }
}

function comparePw() {
    if(pw2.value === pw1.value && pw2.value != "") {
        pwImg2.src = "/VIEW/join/iamges/lock2.jpg";
        error[2].style.display = "none";
    }else if(pw2.value !== pw1.value) {
        pwImg2.src = "/VIEW/join/iamges/unlock2.jpg";
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
    } 

    if(pw2.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    }
}

function checkName() {
    var namePattern = /[a-zA-Z가-힣]/;
    if(userName.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
    } else {
        error[3].style.display = "none";
    }
}


function isBirthCompleted() {
    var yearPattern = /[0-9]{4}/;

    if(!yearPattern.test(yy.value)) {
        error[4].innerHTML = "태어난 년도 4자리를 정확하게 입력하세요.";
        error[4].style.display = "block";
    } else {
        isMonthSelected();
    }


    function isMonthSelected() {
        if(mm.value === "월") {
            error[4].innerHTML = "태어난 월을 선택하세요.";
        } else {
            isDateCompleted();
        }
    }

    function isDateCompleted() {
        if(dd.value === "") {
            error[4].innerHTML = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        } else {
            isBirthRight();
        }
    }
}



function isBirthRight() {
    var datePattern = /\d{1,2}/;
    if(!datePattern.test(dd.value) || Number(dd.value)<1 || Number(dd.value)>31) {
        error[4].innerHTML = "생년월일을 다시 확인해주세요.";
    } else {
        checkAge();
    }
}




function isEmailCorrect() {
    var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

    if(email.value === ""){ 
        error[6].style.display = "none"; 
    } else if(!emailPattern.test(email.value)) {
        error[6].style.display = "block";
    } else {
        error[6].style.display = "none"; 
    }

}

function checkPhoneNum() {
    var isPhoneNum = /([01]{2})([01679]{1})([0-9]{3,4})([0-9]{4})/;

    if(mobile.value === "") {
        error[7].innerHTML = "필수 정보입니다.";
        error[7].style.display = "block";
    } else if(!isPhoneNum.test(mobile.value)) {
        error[7].innerHTML = "형식에 맞지 않는 번호입니다.";
        error[7].style.display = "block";
    } else {
        error[7].style.display = "none";
    }

    
}

function findAddr(){
  new daum.Postcode({
       oncomplete: function(data) {
          
          console.log(data);
          
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
           // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var roadAddr = data.roadAddress; // 도로명 주소 변수
           var jibunAddr = data.jibunAddress; // 지번 주소 변수
           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           if(roadAddr !== ''){
               document.getElementById("address").value = roadAddr;
           } 
           else if(jibunAddr !== ''){
               document.getElementById("address").value = jibunAddr;
           }
       }
   }).open();
}
</script>