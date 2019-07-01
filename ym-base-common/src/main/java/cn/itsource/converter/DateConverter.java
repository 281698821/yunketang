/**
 * 代号:隐无为
 * 修改人：
 * 描述：
 */
package cn.itsource.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 用途：全局日期处理
 */
public class DateConverter implements Converter<String, Date> {
	   @Override
	   public Date convert(String source) {
	      SimpleDateFormat simpleDateFormat =null;
	      Date date=null;
	      try {
	    	  //  判断两种时间格式
	    	  if(source.contains(":")){
	    		  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		  date= simpleDateFormat.parse(source);
	    	  }else{
	    		  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    		  date= simpleDateFormat.parse(source);
	    	  }
	        return date;
	      } catch (ParseException e) {
	        e.printStackTrace();
	      }
	      return null;
	   }
}
