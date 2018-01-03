package com.blunt;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 节点
 * @author: maxiaodong     
 * @date: 2018年1月3日 下午5:49:59
 */
public class Node {
	private String name;//节点名称
	private Integer distance;//节点距离目标节点的最短距离
	public Map<Node,Integer> siblings=new HashMap<Node, Integer>();//相邻边 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Node(String name) {
		super();
		this.name = name;
	}
	public void addLine(Node node,Integer line) {
		siblings.put(node, line);
	}
	
}
