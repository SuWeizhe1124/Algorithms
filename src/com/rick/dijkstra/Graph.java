package com.rick.dijkstra;

import java.util.Vector;

/**
 * @Description: Dijkstra算法查找最长路径，结论：失败
 * @author: maxiaodong     
 * @date: 2018年3月6日 上午12:56:57
 */
public class Graph {
	public Vector<Node> s=new Vector<>();//查找过的节点
	private Vector<Node> u=new Vector<>();//带查找节点
	
	public Graph(Node[] nodes) {
		for (Node node : nodes) 
			u.add(node);	
	}

	public static void main(String[] args) {
		Node a=new Node("a");
		Node b=new Node("b");
		Node c=new Node("c");
		Node d=new Node("d");
		Node e=new Node("e");
		Node f=new Node("f");
		Node g=new Node("g");
		//添加边
		a.addLine(b, 12);
		a.addLine(g, 14);
		a.addLine(f, 16);

		b.addLine(c, 10);
		b.addLine(f, 7);

		c.addLine(d, 3);
		c.addLine(e, 5);
		c.addLine(f, 6);

		d.addLine(e, 4);

		e.addLine(f, 2);
		e.addLine(g, 8);

		f.addLine(g, 9);
		
		Graph graph=new Graph(new Node[] {a,b,c,d,e,f});
		graph.caculate(d, c);
	}
	/**
	 * @description: 计算俩节点之间的最短路径
	 * @author: maxiaodong
	 */
	public void caculate(Node a,Node b) {
		a.path.add(a);
		eachNode(a,b);
		String path="[";
		for (Node node : b.path) 
			path+=node.getName()+",";
		System.err.println("从节点"+a.getName()+"到节点"+b.getName()+"最短路径为："+path.substring(0,path.length()-1)+"],距离为："+b.getDistance());
	}
	/**
	 * @description: 选取节点迭代遍历子节点
	 * @author: maxiaodong
	 */
	private void eachNode(Node node,Node b) {
		s.add(node);//加入已遍历节点
		u.remove(node);
		if(u.size()==0)
			return;
		Node sort=node.getSortNode(this);
		if(sort==b)
			return;
		eachNode(sort,b);
	}
	/**
	 * @description: 计算当前节点最优路径到某个节点的距离
	 * @author: maxiaodong
	 */
	public Integer getDistance(Vector<Node> path,Node o) {
		if(path.size()==0)
			return 0;
		int d=0;
		Node f=path.get(0);
		Node se=null;
		for (int i = 1; i < path.size(); i++) {
			se=path.get(i);
			d+=f.siblings.get(se);
			f=path.get(i);
		}
		return f==o?0:d+f.siblings.get(o);
	}
}
