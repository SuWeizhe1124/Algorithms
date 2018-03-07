package com.rick.part1;

import java.util.Map.Entry;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description: 第一题:JSON格式转换
 * @author: maxiaodong     
 * @date: 2018年3月7日 下午10:41:33
 */
public class JsonFormater {
	private static final String TAG=".";
	public static void main(String[] args) {
		JSONObject json=new JSONObject();
		json.put("a", "1");
		JSONObject b=new JSONObject();
		JSONObject c=new JSONObject();
		c.put("e", "3");
		b.put("c", c);
		b.put("d", new int[]{3,4});
		json.put("b", b);
		JSONObject f=new JSONObject();
		f.put("x", "2");
		f.put("g", "3");
		f.put("r", "6");
		json.put("f", f);
		JSONObject result=new JSONObject();//结果集
		System.out.println("before:"+json);
		format(json, result,null);
		System.out.println("after:"+result);
	}
	/**
	 * @description: 用一句话描述该方法
	 * @param json
	 * @param result
	 * @param par 参数  
	 * @author: maxiaodong
	 */
	public static void format(JSONObject json,JSONObject result,String parent) {
		for (Entry<String, Object> entry : json.entrySet()) {
			if(entry.getValue() instanceof JSONObject) {
				JSONObject n=(JSONObject)entry.getValue();
				format(n, result, (parent==null?"":parent+TAG)+entry.getKey());
			}else {
				result.put((parent==null?"":parent+TAG)+entry.getKey(), entry.getValue());
			}
		}
	}
}
