/**
 * 依赖jQuery,localResizeIMG(lrz.all.bundle.js)
 */

/**
 * 
 * @param obj
 * @param url
 * @param paramData
 * @returns
 */
function MyAutoUpload(obj,showId,url,paramData,callBack){
	var id = obj.id;
	var isImage = false;
	var realPath = obj.value;
	var thisSuffix = obj.getAttribute('suffix').toLowerCase();
	var imageSuffix = "bmp,gif,jpeg,jpg,jpe,psd,png,svg,svgz,tiff,tif";
	var suffix = realPath.substr(realPath.lastIndexOf(".") + 1).toLowerCase();
	if(imageSuffix.indexOf(suffix)!=-1){
		isImage = true;
	}
	if(typeof(thisSuffix)!='undefined'&&
			thisSuffix!='*'&&
			thisSuffix!=''&&
			thisSuffix.indexOf(suffix)==-1){
		mui.alert("只允许上次类型为："+thisSuffix+"的文件!");
		return;
	}
	if(isImage){
		 lrz(obj.files[0], {
		        width: 800
		    }).then(function (rst) {
		    	if(showId!=null){
		    		document.getElementById(showId).src=rst.base64;
		    	}
		    	var xhr = new XMLHttpRequest();
		        xhr.open('POST', url);
		        xhr.onload = function () {
//		            var data = JSON.parse(xhr.response);
		            var data = xhr.response;
		            if (xhr.status === 200) {
		            	if(typeof(callBack)=='function'&&typeof(data)!='undefined'){
		            		callBack(data);
		            	}else{
		            		callBack;
		            	}
		            } else {
		            	alert("上传图片出现错误，localResizeIMG_plus.js第48行。"+data);
		            }
		        };
		        xhr.onerror = function (err) {
		            alert('未知错误:' + JSON.stringify(err, null, 2));
		        };
		        for(key in paramData){
		    		rst.formData.append(key, paramData[key]);
		    	}
		        if(typeof(fileSize)!='undefined'&&fileSize!=null&&fileSize!=''){
		        	rst.formData.append('fileLen', fileSize);
		        }	
		    	xhr.send(rst.formData);
		    }).catch(function (err) {
	            alert("上传图片组件出现错误,"+err);
	        });
	}else{
		var xhr = new XMLHttpRequest();
		var formData = new FormData();
        xhr.open('POST', url);
        xhr.onload = function () {
            var data = xhr.response;
            if (xhr.status === 200) {
            	if(typeof(callBack)=='function'&&typeof(data)!='undefined'){
            		callBack(data);
            	}else{
            		callBack;
            	}
            } else {
                alert("上传文件出现错误，localResizeIMG_plus.js第77行。"+data);
            }
        };
        xhr.onerror = function (err) {
            alert('未知错误:' + JSON.stringify(err, null, 2));
        };
        formData.append('file',obj.files[0]);
        for(key in paramData){
    		formData.append(key, paramData[key]);
    	}
        if(typeof(fileSize)!='undefined'&&fileSize!=null&&fileSize!=''){
        	formData.append('fileLen', fileSize);
        }	
    	xhr.send(formData);
	}
}
