package cn.itsource.common;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  响应单例类  spring Component 
 */
@Component
public class ResponseAPI {
	//实例化jackson mapper 
	public  ObjectMapper mapper = new ObjectMapper();
	public  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * jackson 的 json 序列化
	 */
	public  String getJsonString(Object object){
		String result =null;
		try {
			
			mapper.setDateFormat(sdf);
			result= mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	/**
//	 * jackson 的 json 序列化 (null 忽略)
//	 */
//	public  String getJsonStringNoNull(Object object){
//		String result =null;
//		try {
//			 ObjectMapper mapperNoNull1 = new ObjectMapper();
//			 System.out.println(mapperNoNull1.getSerializerProvider());
//			 System.out.println(mapper.getSerializerProvider());
//			 mapperNoNull1.setDateFormat(sdf);
//			 mapperNoNull1.setSerializationInclusion(Inclusion.NON_NULL);  
//			result= mapper.writeValueAsString(object);
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	/**@功能: json转List集合
	 *  @代号:隐无为
	 * @param jsonStr
	 * @param targetClass  目标类
	 * @return list<targetClass>  返回list集合
	 *//*
	public <T> T getJsonToList(String jsonStr, Class<?>targetClass)  {
	   JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, targetClass);
	   try {
			return mapper.readValue(jsonStr, javaType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
            return null;
	}
	 
	*//**@功能: json 转换 bean 对象
	 * @代号:隐无为
	 * @param jsonStr
	 * @return
	 *//*
	public <T> T getJsonToBean(String jsonStr,Class<T> c){
		
		try {
			return mapper.readValue(jsonStr, c);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 *//**@功能: 集合类转换
	 * @代号:隐无为
	 * @param jsonStr
	 * @param collectionClass 集合类class
	 * @param targetClass  目标类 
	 * @return
	 *//*
	public <T> T readJson(String jsonStr, Class<?> collectionClass, Class<?>... targetClass)  {
	       JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, targetClass);
	       try {
			return mapper.readValue(jsonStr, javaType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	       return null;
	 }
	 */
	
	
	//测试
//	 public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		 ResponseAPI api=new ResponseAPI();
//		 Test t=new Test();
//		 t.setId(null);//int 类型
//		 t.setName(null);//字符串
//		 t.setDate(new Date());//时间
////		 String json1= api.getJsonString(t);
////         Test tt=api.getJsonToBean(json1, Test.class);
////         System.out.println(tt.getDate());
//		 Test t2=new Test();
//		 t2.setId(1);//int 类型
//		 t2.setName("T");//字符串
//		 t2.setDate(new Date());//时间
//		 List<Test>list=new ArrayList<Test>();
//		 list.add(t2);
//		 list.add(t);
//		
//		 String json3= api.getJsonStringNoNull(list);
//		 System.out.println(json3);
//		 String json2= api.getJsonString(list);
//		 System.out.println(json2);
////		 List<Test> list2 = api.getJsonToList(json2, Test.class);
////		 System.out.println(list2.size());
////		 
//	 }
	
	
}

