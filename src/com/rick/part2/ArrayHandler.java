package com.rick.part2;

import java.util.Map.Entry;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description: 第二题：数据存取
 * @author: maxiaodong     
 * @date: 2018年3月8日 上午1:29:27
 */
public class ArrayHandler {
    private static final String QP_SEP_S = ";";
    private static final String SEPARATOR = "=";
    private static final String LINE = "\n";
	public static void main(String[] args) {
		JSONArray array=new JSONArray();
		JSONObject obj1=new JSONObject();
		obj1.put("k1", "v1");
		obj1.put("k2", "v2");
		array.add(obj1);
		JSONObject obj2=new JSONObject();
		obj2.put("kA", "vA");
		obj2.put("kB", "vB");
		array.add(obj2);
		System.out.println(store(array));
		System.out.println(load(store(array)));
	}
	/**
	 * @description: 把数组保存到一个文本字符串中
	 * @param array
	 * @return 参数  
	 * @author: maxiaodong
	 */
	public static String store(JSONArray array) {
		StringBuilder builder=new StringBuilder();
		for (Object object : array) {
			JSONObject obj=(JSONObject) object;
			for (Entry<String, Object> entry : obj.entrySet()) {
				builder.append(entry.getKey());
				builder.append(SEPARATOR);
				builder.append(entry.getValue());
				builder.append(QP_SEP_S);
			}
			builder.append(LINE);
		}
		return builder.toString();
	}
	/**
	 * @description: 把文本字符串中的内容读取为数组
	 * @param str
	 * @return 参数  
	 * @author: maxiaodong
	 */
	public static JSONArray load(String str) {
		String[] array=str.split(LINE);
		JSONArray jsonArray=new JSONArray();
		for (String string : array) {
			JSONObject jsonObj=new JSONObject();
			for (String textObj : string.split(QP_SEP_S)) {
				jsonObj.put(textObj.split(SEPARATOR)[0], textObj.split(SEPARATOR)[1]);
			}
			jsonArray.add(jsonObj);
		}
		return jsonArray;
	}
}
