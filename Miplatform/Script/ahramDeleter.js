﻿//New Script File
//1대 삭제용(부모 데이터셋,자식 데이터셋)
function ahramDeleter(motherdataset,childdataset){
trace("ahramDeleter");
     var rowCount = childdataset.GetRowCount();
	for(var rowNumber = rowCount-1; 0<=rowNumber; rowNumber--){
         childdataset.DeleteRow(rowNumber);
      }
      motherdataset.DeleteRow(motherdataset.row);
   }
