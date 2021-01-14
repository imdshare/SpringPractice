
function nullCheck (x){
	if( x.length == 0 ){
		alert("필수 입력 항목을 입력해주세요.");
		return false;
	}
	return true;
}

/*
 * [01 숫자로 시작해야 하며 그다음에 오는 숫자는 6-9 사이]
 * 그 다음에 '-'가 와야함
 * [0-9 까지 숫자의 3글자 에서 4글자까지]
 * 그 다음에 '-'가 와야함
 * [0-9 까지 숫자의 4글자까지]
 */

function phoneNoCheck(x){
	var validationCode = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	if(x.length == 0){
		return false;
	}
	if(!x.match(validationCode)){
		alert("올바른 핸드폰번호를 입력해주세요.\n - 도 포함해주세요.");
		return false;
	}
	return true;
}
/*
* [영어 알파벳 소문자 a-z 와 영어 알파벳 대문자 A-Z 를 사용할수 있음] : 영어만 가능
*/
function engNameCheck(x){
	var validationCode = /^[a-zA-Z\s]*$/;
	if(x.length == 0){
		return false;
	}
	if(!x.match(validationCode)){
		alert("영어만 입력해주세요.");
		return false;
	}
	return true;
}
/*
 * [한글 가 부터 힣 까지 를 사용할수 있음] : 한글만 가능
 */
function korNameCheck(x){
	var validationCode = /^[ㄱ-ㅎ\s|ㅏ-ㅣ\s|가-힣\s]*$/;
	if(x.length == 0){
		return false;
	}
	if(!x.match(validationCode)){
		alert("한글만 입력해주세요.");
		return false;
	}
	return true;
}
/*
 * [숫자 0-9] : 1글자 이상 5글자 이하 숫자만 가능
 */
function postNoCheck(x){
	var validationCode = /^[\d]{1,5}$/;
	if(x.length == 0){
		return false;
	}
	if(!x.match(validationCode)){
		return false;
	}
	return true;
}

/*
 * [영어 알파벳 a-z 와 영어 알파벳 A-Z 와 숫자 0-9]
 * 가운데 @ 꼭 포함되어야 함
 * [영어 알파벳 a-z 와 영어 알파벳 A-Z 와 숫자 0-9]
 * .이 포함되어야 함
 * [영어 알파벳 a-z 와 영어 알파벳  A-Z]
 */
function emailCheck(x){
	var validationCode = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

	if(x.length == 0){
		return false;
	}
	if(!x.match(validationCode)){
		alert("이메일 형식이 맞지 않습니다.");
		return false;
	}
	return true;
}

/* [공백 체크]
 * 공백만 존재할 경우 false 처리
 *  */
function blankCheck(x){
	var validationCode = /^\s+|\s+$/;
	if(x.length == 0){
		return false;
	}
	if( x.value.replace( validationCode , '' ) == "" ){
	    alert(' 공백만 입력되었습니다 ');
	    return false;
	}
	return true;
}

/*
 * [url 체크]
 * */
function urlCheck(x){
	
	var validationCode = /(http(s)?:\/\/|www.)([a-z0-9\w]+\.*)+[a-z0-9]{2,4}([\/a-z0-9-%#?&=\w])+(\.[a-z0-9]{2,4}(\?[\/a-z0-9-%#?&=\w]+)*)*/gi;
	if(x.length == 0){
		return false;
	}
	if(!x.match(validationCode)){
		alert("올바른 url을 입력해주세요. http://를 포함하여 입력해주세요.");
		return false;
	}
	return true;
}

/* [공백 체크]
 * 공백이 존재할 경우 false 처리
 *  */
function intputBlankCheck(x){
	var validationCode = /[\s]/;
	if(x.length == 0){
		return false;
	}
	if( x.search(validationCode) !=  -1 ){
	    alert(' 공백은 사용할 수 없습니다. ');
	    return false;
	}
	return true;
}

/* [특수문자 체크]
 * 특수문자가 존재할 경우 false 처리
 *  */
function intputSpecialTextCheck(x){
	var validationCode = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

	if(x.length == 0){
		return false;
	}
	if( validationCode.test(x) ){
		alert('특수문자는 사용할 수 없습니다.');
	    return false;
	}
	return true;
}

/* [숫자 체크]
 * 숫자가 아닌 경우 false 처리
 *  */
function numberCheck(x){
	var validationCode = /[^0-9]/;
	if(x.length == 0){
		return false;
	}
	if( x.match(validationCode) ){
		alert("숫자만 입력가능합니다.");
		return false;
	}
	return true;
}

function checkMaxNum(x) {

    var validationCode = /^(\d{2}([.]\d{0,1})?)?$/;

    if(x.length == 0){
		return false;
	}
	if( x.match(validationCode) ){
		alert("두자리이하 숫자만 입력가능하며,\n소수점 첫째자리까지만 허용됩니다.");
		return false;
	}
	return true;
}

//첨부파일 확장자 추출
function getFileExt(_obj) {
	var sFilePath = $("#" + _obj).val();
	if (sFilePath != "") {
	
		if(sFilePath.indexOf('.') >= 0) {
			   exp = sFilePath.substring(sFilePath.lastIndexOf('.')+1, sFilePath.length).toLowerCase();			   
			   return exp;
		}		
	}	  
	return "";
}

//첨부파일 허용 확장자 체크 
function checkFileExt(_obj, allowExts) {
	if (allowExts) {
		if (typeof(_obj) == 'object') {
			_obj = $(_obj).context.id;	
		}
		var exts = allowExts.toLowerCase().split(",");
		var fext = getFileExt(_obj).toLowerCase();	
		var chk  = false;
		if (fext != "" && fext.length > 0) {
			for(var i=0 ; i < exts.length ; i++){
				var ext = exts[i].toLowerCase();
			    if(fext == ext){
			    	chk =  true;
			    }
			}
		} else {
			chk =  true;
		}
	}
	return chk;
}

function checkFileExtReturn(_obj, allowExts){
    var checkedReturn = checkFileExt(_obj, allowExts);

    if( !checkedReturn ){
        alert(allowExts + ' 확장자만 가능합니다.');
        $('#' + _obj).val('');
        
        return false;
    }
    return true;
}












