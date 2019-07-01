/**
 * 代号:隐无为
 * 文件名：UploadController.java
 * 修改人：
 * 描述：
 */
package cn.itsource.common.upload;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;

import cn.itsource.common.base.controller.BaseController;
import cn.itsource.utils.JsonReturnData;

/**
 * 用途：上传图片
 */
@Controller
@RequestMapping("/common/upload")
@SuppressWarnings("all")
public class UploadController extends BaseController {

	/**
	 * 功能: 上传文件(单个)  可上传 图片 、excel...等等
	 * 代号:隐无为
	 * @param request
	 * @param file:图片
	 * @param path:存放的路径
	 * @return
	 */
	@RequestMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(HttpServletRequest request, MultipartFile file, String path) {
		JsonReturnData<String> jsonReturnData = this.getUploadPath(request, file, path);   
		return responseAPI.getJsonString(jsonReturnData);
	}

	/**
	 * 功能: 上传文件(单个)  可上传 图片 、excel...等等
	 * 代号:隐无为
	 * @param request
	 * @param file:图片
	 * @param path:存放的路径
	 * @return
	 */
	@RequestMapping("/uploadLayedit")
	@ResponseBody
	public String uploadLayedit(HttpServletRequest request, MultipartFile file, String path) {
		JsonReturnData<String> jsonReturnData = this.getUploadPath(request, file, path);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","上传成功");
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("src","/"+jsonReturnData.getData());
        map.put("data",dataMap);
        return responseAPI.getJsonString(map);
	}

	/*
	 * 上传文件(批量) 可上传 图片 、excel...等等
	 */
	@RequestMapping(value = "/uploadFiles", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String uploadFiles(HttpServletRequest request, MultipartFile[] file, String path) {
		JsonReturnData<List<String>> jsonImgs=new JsonReturnData<List<String>>();
		if(StringUtil.isEmpty(path)){ 
			path="other/img";
		}
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < file.length; i++) {
			//uniqueName += file[i].getOriginalFilename() + ",";// 得到文件名
			JsonReturnData<String> jsonReturnData = this.getUploadPath(request, file[i], path);
			if(jsonReturnData.getCode()==200){
				list.add(jsonReturnData.getData());
			}
		}
		if(list.size()!=file.length){
			jsonImgs.setMsg("批量上传错误--丢失照片--请重新上传丢失照片");
			jsonImgs.setCode(505);// 批量上传错误错误码
		}else{
			jsonImgs.setData(list);
			jsonImgs.setCode(200);
			jsonImgs.setMsg("批量上传成功");
		}
		return responseAPI.getJsonString(jsonImgs);
	}

	/**
	 * @功能: 获取上传文件的路径
	 * @代号:隐无为
	 * @param request
	 * @param file
	 * @param path
	 * @return
	 */
	public JsonReturnData<String> getUploadPath(HttpServletRequest request, MultipartFile file, String path) {
		JsonReturnData<String> jsonReturnData = new JsonReturnData<String>();
		if(StringUtil.isEmpty(path)){ 
			path="other/img";
		}
		String basePath = request.getSession().getServletContext().getRealPath(path);
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		// 日期格式文件夹
		String datePath = sdf.format(new Date());
		// uuid随机名
		String uuidPath = UUID.randomUUID().toString();
		// 文件的后缀名
		String fileExit = getFileExit(file.getOriginalFilename());
		// 创建目录
		File dir = new File(basePath + datePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 创建文件的路径
		String newFilePath = basePath + datePath + uuidPath + fileExit;
		// 数据库存储的文件相对项目的路径
		String returnName = path + datePath + uuidPath + fileExit;
		File targetFile = new File(newFilePath);
		try {
			// 转存文件
			file.transferTo(targetFile);
			jsonReturnData.setCode(200);
			jsonReturnData.setMsg("success");
			jsonReturnData.setData(returnName);
		} catch (Exception e) {
			jsonReturnData.setCode(500);
			jsonReturnData.setMsg("error-upload");
			e.printStackTrace();
		}
		return jsonReturnData;
	}
	
	
	
	
	/**
	 * @功能: 获取上传文件的路径 硬盘
	 * @代号:隐无为
	 * @param request
	 * @param file
	 * @param path
	 * @return
	 */
	public JsonReturnData<String> getUploadDisk(HttpServletRequest request, MultipartFile file, String path) {
		JsonReturnData<String> jsonReturnData = new JsonReturnData<String>();
		if(StringUtil.isEmpty(path)){ 
			path="other/img";
		}
		//String basePath = request.getSession().getServletContext().getRealPath(path);
		String basePath = "D://upload//" + path;
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		// 日期格式文件夹
		String datePath = sdf.format(new Date());
		// uuid随机名
		String uuidPath = UUID.randomUUID().toString();
		// 文件的后缀名
		String fileExit = getFileExit(file.getOriginalFilename());
		// 创建目录
		File dir = new File(basePath + datePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 创建文件的路径
		String newFilePath = basePath + datePath + uuidPath + fileExit;
		// 数据库存储的文件相对项目的路径
		String returnName = path + datePath + uuidPath + fileExit;
		File targetFile = new File(newFilePath);
		try {
			// 转存文件
			file.transferTo(targetFile);
			jsonReturnData.setCode(200);
			jsonReturnData.setMsg("success");
			jsonReturnData.setData(returnName);
		} catch (Exception e) {
			jsonReturnData.setCode(500);
			jsonReturnData.setMsg("error-upload");
			e.printStackTrace();
		}
		return jsonReturnData;
	}
	
	
	

	
	
	
	
	
	/**
	 * 删除文件
	 * 
	 * @param imagepath
	 */
	public void deleteFile(String imagepath) {
		if (imagepath != null) {
			File image = new File(imagepath);
			if (image.exists()) {
				image.delete();
			}
		}
	}

	/**
	 * 取后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public String getFileExit(String fileName) {
		int index = fileName.lastIndexOf('.');
		return fileName.substring(index);
	}

}
