/**
 * 代号:隐无为 2018：
 * 文件名：LayuiTable.java
 * 修改人：
 * 描述：
 */
package cn.itsource.utils;

import java.util.Map;

/**
 * 用途：layui 的 分页表格
 * 
 * @param <T>
 */
public class PageTable<T> {

	/**
	 * 响应码
	 */
	private Integer code;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 总记录数
	 */
	private Long count;

	/**
	 * 数据集合
	 */
	private T data;

	/**
	 * json数据map 额外数据
	 */

	private Map<String, Object> jsonMap;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public PageTable() {

	}

	public PageTable(Integer code,String msg ,T data) {
		this.code=code;
		this.msg=msg;
		this.data=data;
	}

	public PageTable(Long count,T data) {
		this.code=200;
		this.msg="成功响应数据";
		this.count=count;
		this.data=data;
	}

}
