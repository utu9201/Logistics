﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿function basicTransaction(){

  http.sync=true;
  Transaction("codeList","svcBase::code.do?method=findCodeList","","gds_code=gds_code","","callback");
  Transaction("codeDetailList","svcBase::codeDetail.do?method=findCodeDetailList","","gds_codeDetail=gds_codeDetail","","callback");
  	transaction("findDeptList",
				"svcEmp::/dept.do?method=findDeptList",
				"",
				"gds_dept=gds_dept",
				"",
				"callback");
  http.sync=false;

}


