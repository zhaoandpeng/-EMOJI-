package cn.com.mrs.demo;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerDemo {
	
	private Configuration cfg;   //模版配置对象 
	
	public static void main(String[] args) throws Exception {
		FreeMarkerDemo hf = new FreeMarkerDemo(); 
        hf.init(); 
        hf.process(); 
        //------------------------------------以上为完整的动态模板生成----------------------------
		//创建一个模板对象
//		try {
//			Template t = new Template(null, new StringReader("用户名：${user};URL：    ${url};姓名： 　${name}"), null);
//			//创建插值的Map 
//            Map map = new HashMap(); 
//            map.put("user", "lavasoft"); 
//            map.put("url", "http://www.baidu.com/"); 
//            map.put("name", "百度"); 
//            try {
//            	//执行插值，并输出到指定的输出流中 
//				t.process(map, new OutputStreamWriter(System.out));
//			} catch (TemplateException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
	}
	
	public void init() throws Exception { 
        //初始化FreeMarker配置 
        //创建一个Configuration实例 
        cfg = new Configuration(); 
        //设置FreeMarker的模版文件夹位置 
        cfg.setDirectoryForTemplateLoading(new File("E:\\")); 
	} 

	public void process() throws Exception { 
        //构造填充数据的Map 
        Map map = new HashMap(); 
        map.put("user", "lavasoft"); 
        map.put("url", "http://www.baidu.com/"); 
        map.put("name", "百度"); 
        //创建模版对象 
        Template t = cfg.getTemplate("test.ftl"); 
        //在模版上执行插值操作，并输出到制定的输出流中 
        t.process(map, new OutputStreamWriter(System.out)); 
	} 
}
