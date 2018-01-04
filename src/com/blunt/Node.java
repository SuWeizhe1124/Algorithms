package com.blunt;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

/**
 * @Description: 节点
 * @author: maxiaodong     
 * @date: 2018年1月3日 下午5:49:59
 */
public class Node {
	private String name;//节点名称
	private Integer distance=0;//节点距离目标节点的最短距离
	public Map<Node,Integer> siblings=new HashMap<Node, Integer>();//相邻边
	public Vector<Node> path=new Vector<>();//当前最短路径
	public boolean gray=false;
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
		node.siblings.put(this, line);
	}
	/**
	 * @description: 获取距离最小的一个节点
	 * @author: maxiaodong
	 */
	public Node getSortNode(Graph s) {
		gray=true;
		Node temp = null;//权值最短的节点
		int i=0;
			
		for (Entry<Node, Integer> entry : siblings.entrySet()) {
			Node node=entry.getKey();
			if(s.s.contains(node))//排除已经遍历过的节点
				continue;
			Integer d=node.getDistance();//获取当前已有的距离
			Integer ds=s.getDistance(path,node);//计算当前的路径距离
			if(d!=0) {
				if(ds<d) {//如果当前路径距离小于已有的路径距离则改变权值为当前路径
					node.setDistance(ds);
					node.path.clear();
					node.path.addAll(path);//把当前节点的最优路径赋值给此节点
					node.path.add(node);
				}
			}else {
				node.setDistance(ds);
				node.path.addAll(path);
				node.path.add(node);
			}
		//============计算出距离最短的节点
			if(i==0) {
				temp=node;
				i=ds;
				continue;
			}else {
				if(ds<i) {
					i=ds;
					temp=node;
				}
			}
		}
		//==============计算出距离最短的节点
		
		//==============如果遍历进入死胡同（该节点周围所有节点都已经遍历过） 则返回上一层节点遍历
		if(temp==null)
			temp=s.s.get(s.s.indexOf(this)-1);
		return temp;
	}
	
}
