package com.rick.dga;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @Description: 有向无环图
 * @author: maxiaodong     
 * @date: 2018年3月7日 上午12:59:51
 */
public class Grap {

	public Vector<Node> s=new Vector<>();//查找过的节点
	private Vector<Node> u=new Vector<>();//待查找节点
	public Grap(Node[] nodes){
		for (Node node : nodes) 
			u.add(node);	
	}
	public static void main(String[] args) {
		Node r=new Node("r",5);
		Node s=new Node("s",2);
		Node t=new Node("t",3);
		Node x=new Node("x",2);
		Node y=new Node("y",1);
		Node z=new Node("z",7);
		

		r.addLineOut(s);
		r.addLineOut(t);

		s.addLineIn(r);
		s.addLineOut(t);
		s.addLineOut(x);

		t.addLineIn(r);
		t.addLineIn(s);
		t.addLineOut(x);
		t.addLineOut(y);
		t.addLineOut(z);

		x.addLineIn(s);
		x.addLineIn(t);
		x.addLineOut(y);
		x.addLineOut(z);

		y.addLineIn(t);
		y.addLineIn(x);
		y.addLineOut(z);

		z.addLineIn(t);
		z.addLineIn(x);
		z.addLineIn(y);
		
		Grap grap=new Grap(new Node[] {r,s,t,x,y,z});
		grap.topologicalSort(grap);
		grap.findPath(r);
		
	}
	/**
	 * @description: 进行拓扑排序
	 *  参数  
	 * @author: maxiaodong
	 */
	public void topologicalSort(Grap grap) {
		Queue<Node> queue= new LinkedList<Node>();   
		//先把没有入度的节点加入队列
		for (Node node : grap.u) {
			if(node.in.size()==0) {
				queue.add(node);
			}
		}
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			for(Node node:temp.out){//没有入度的所有出度节点
				node.in.remove(temp);//删除出度节点的入度
				if(node.in.size()==0) {//如果没有入度则加入队列  (说白了就是把相关的边去掉  如果没有入边则加入队列)
					queue.add(node);
					System.out.print(">"+node.name);
				}
			}
		}
	}
	public void findPath(Node node) {
//		Vector<Node> v=node.out;
//		u.remove(node);
		Queue<Node> queue= new LinkedList<Node>();  
		queue.add(node);
		itreator(queue);
		for (Node node2 : u) {
			System.out.println(node2.name+":"+node2.distance);
		}
		
	}
	public void itreator(Queue<Node> queue) {
		Queue<Node> result= new LinkedList<Node>();   
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			for (Node n : node.out) {
				result.add(n);//下一层需要遍历的节点
				if(n.distance==Integer.MAX_VALUE)
					n.distance=node.weight+n.weight;
				else if((node.distance+n.weight)>n.distance){
					n.distance=node.distance+n.weight;
				}
			}
		}
		if(result.isEmpty())
			return;
		itreator(result);
		
	}
}
