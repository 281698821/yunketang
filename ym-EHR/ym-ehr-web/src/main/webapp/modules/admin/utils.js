//utils.js   主页 js
layui.define(['element'], function(exports) {
	var $ = layui.jquery;
	var utils = {
		// json去掉为空的数据
		removeNull:function (data) {
			var result={};
               for (var key in data){
               	    if(data[key]){
                        result[key]=data[key];
					}else{
                        result[key]=undefined;
					}
			   }
			   return result;
    }


	}

	exports('utils', utils);
});