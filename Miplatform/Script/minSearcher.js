﻿//민서표검색기 (검색할 문자열,대상칼럼,데이터셋)
function minSearcher(sarchString,searchCol,dataSet){
   trace("minSearcher");
   var sFilter;
   if(sarchString = ""){
      dataSet.UnFilter();
      trace("a");
   }else{
      if(sarchString.trim().length > 0 ) 
         sFilter += " || pos("+searchCol+","+quote(sarchString) + ") >= 0";
         
         dataSet.Filter(sFilter);
   }
   
}