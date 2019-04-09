﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿//New Script File
//견적번호 생성함수

//controller에서 생성할거임
//function estimateCodeNo(day){

// var estiCnt=0;

// var allEstimateRows=gds_estimate.GetRowCountNF();

	 // for(var i=0; idx<allEstimateRows; i++){
			// var estimateNo=gds_estimate.GetColumnNF(i,"ESTIMATE_NO");
			// estiCnt=codeMaker(estiCnt);
			// var newEstiNo="("+global_workplace+"/"+global_deptCode+")"+"ESTI"+day+"-"+estiCnt;
			// iif(estimateNo=newEstiNo,estiCnt++,estiCnt);
		// }
		// estiCnt=gds_estimate.GetRowCount()+1;
		// var newEstiNo="("+global_workplace+"/"+global_deptCode+")"+"ESTI"+day+"-"+estiCnt;



		// return newEstiNo;
// }


//수주번호 생성함수
// function contractCodeNo(day){
// var contCnt=0;

// var allContractRows=gds_contract.GetRowCountNF();

	// for(var idx=0; idx<allContractRows; idx++){
			// var contractNo=gds_contract.GetColumnNF(idx,"CONTRACT_NO");
			// contCnt=codeMaker(contCnt);
			// var newContNo="("+global_deptCode+"/"+global_empCode+")"+"CONT"+day+"-"+contCnt;
			// iif(contractNo=newContNo,contCnt++,contCnt);
		// }
		// contCnt=codeMaker(contCnt);
		// var newContNo="("+global_deptCode+"/"+global_empCode+")"+"CONT"+day+"-"+contCnt;
		// var nRow=this.gds_contract.rowposition;
		// var scode=this.gds_contract.GetColumn(nRow,"CONTRACT_NO");
	
		// return newContNo;
// }

//견적상세번호 (글로벌 견적번호 입력)
//controll에서 생성해줌
// function estimateDetailNo(estimateNo){
// var estiDcnt=0;
		// var allEstimateDetailRows=gds_estimateDetail.GetRowCount();
		
		// for(var idx=0; idx<allEstimateDetailRows; idx++){
			// var estimateDetailNo=gds_estimateDetail.GetColumn(idx,"ESTIMATE_DETAIL_NO");
			// estiDcnt=codeMaker(estiDcnt);
			// var newEstimateDetailNo=estimateNo+estiDcnt;
			// iif(estimateDetailNo=newEstimateDetailNo,estiDcnt++,estiDcnt);
		// }
		// estiDcnt=codeMaker(estiDcnt);
		// var newEstimateDetailNo=estimateNo+estiDcnt;
		// return newEstimateDetailNo;

// }
//// mps번호
function mpsNo(inputday){
var mpsCnt=0;
trace(inputday);

var allMpsRows=gds_mps.GetRowCountNF();

	for(var idx=-3; idx<allMpsRows; idx++){
			var mpsNo=gds_mps.GetColumnNF(idx,"MPS_NO");
			mpsCnt=codeMaker(mpsCnt);
			var newMpsNo="MPSN"+inputday+"-"+mpsCnt;
			iif(mpsNo=newMpsNo,mpsCnt++,mpsCnt);
		}
		mpsCnt=codeMaker(mpsCnt);
		var newMpsNo="MPSN"+inputday+"-"+mpsCnt;
	
		return newMpsNo;
}
//// 통합형 코드 프로토타입
function templeteNo(day,dataset,colname,serialID,filter){
var Cnt=0;

var alldataRows=dataset.GetRowCountNF();

	for(var idx=0; idx<alldataRows; idx++){
			var oldNo=dataset.GetColumnNF(idx,colname);
			Cnt=codeMaker(Cnt);
			var newNo=serialID+day+"-"+Cnt;
			iif(oldNo=newNo,Cnt++,Cnt);
		}
		Cnt=codeMaker(Cnt);
		var newNo=serialID+day+"-"+Cnt;
		trace(newNo);
		return newNo;
}
///////필터해제 안하는 버전
function templeteNonF(day,dataset,colname,serialID){
var Cnt=0;

var alldataRows=dataset.GetRowCountNF();

	for(var idx=0; idx<alldataRows; idx++){
			var oldNo=dataset.GetColumnNF(idx,colname);
			Cnt=codeMaker(Cnt);
			var newNo=serialID+day+"-"+Cnt;
			iif(oldNo=newNo,Cnt++,Cnt);
		}
		Cnt=codeMaker(Cnt);
		var newNo=serialID+day+"-"+Cnt;
		
		trace(newNo);
		return newNo;
}

//01 형식의 번호생성 함수
function codeMaker(num) {
	num = ToString(num);
	trace(num);
 return iif(num.length >=2,  num ,"0"+ToString(num));
}

//각종 3자리 코드생성- 그리드에 바인드 데이터셋과 코드 칼럼명이 매개변수로 필요
function templeteCodeNo(gds_dataset,colname){
gds_dataset.unfilter();
	var newCodeCnt=0;
	trace(gds_dataset);
	trace(colname);
	var allGridRows=gds_dataset.GetRowCount();
		var code=gds_dataset.GetColumn(0,colname);
		var originCode=code.substr(0,3);
	for(var idx=0; idx<allGridRows; idx++){
			var codeNo=gds_dataset.GetColumn(idx,colname);
			trace(codeNo);
			trace(originCode);
			newCodeCnt=codeMaker(newCodeCnt);
			
			var newcodeNo=originCode+"-"+newCodeCnt;
			trace("newcodeNo"+newcodeNo);
			iif(codeNo=newcodeNo,newCodeCnt++,newCodeCnt);
		}
		newCodeCnt=codeMaker(newCodeCnt,3);
	

		var newcodeNo=originCode+"-"+newCodeCnt;
		
		return newcodeNo;

}


///db 연동 시퀀스형 코드생성
var serialCode;
function seqSerialNo(serialID,findSeq){
http.Sync=true;

Transaction("takeSerial",
"svcBase::code.do?method=takeSerialCode"
,""
,""
,"findSeq ='" + findSeq +"'",
,"codeCallback"); 

http.Sync=false;

		var newNo=serialID+serialCode;
		trace(serialCode);

		return newNo;
		
}