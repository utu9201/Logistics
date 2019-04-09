//New Script File
function searchAddress(dong, page){
   http.Sync="true";
   Transaction("findPostList","SvcBase::postList.do?method=findPostList","","gds_post=gds_post","dong='"+dong+"' page='"+globalPage+"'","callback");
   http.Sync="false";
} 