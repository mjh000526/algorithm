import java.util.*;
class Solution {
    StringBuilder answer;
    public String solution(int n, int k, String[] cmd) {
        this.answer = new StringBuilder("O".repeat(n));
        Node head = new Node(null,0,null);
        Node node = head;
        for(int i=1;i<n;i++){
            Node addNode = new Node(node,i,null);
            node.next = addNode;
            node=addNode;
        }
        ArrayDeque<Node> log = new ArrayDeque<Node>();
        node = head;
        for(int i=0;i<k;i++){
            node = node.next;
        }
        for(String str : cmd){
            String[] command = str.split(" ");
            switch(command[0]){
                case "U":
                    node = this.upMove(node,Integer.parseInt(command[1]));
                    break;
                case "D":
                    node = this.downMove(node,Integer.parseInt(command[1]));
                    break;
                case "C":
                    node = this.remove(node,log);
                    break;
                case "Z":
                    this.rollback(log);
                    break;
            }
        }


        return answer.toString();
    }
    public class Node{
        Node pre;
        int num;
        Node next;
        Node(Node pre,int num,Node next){
            this.pre=pre;
            this.num=num;
            this.next=next;
        }
    }

    //메소드리스트
    public Node upMove(Node node, int x){
        for(int i=0;i<x;i++){
            node = node.pre;
        }
        return node;
    }
    public Node downMove(Node node, int x){
        for(int i=0;i<x;i++){
            node = node.next;
        }
        return node;
    }
    public Node remove(Node node, ArrayDeque<Node> log){
        log.push(node);
        this.answer.setCharAt(node.num, 'X');
        if(node.pre==null){
            node.next.pre=null;
            return node.next;
        }
        else if(node.next==null){
            node.pre.next=null;
            return node.pre;
        }

        else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node.next;
        }
    }
    public void rollback(ArrayDeque<Node> log){
        Node node = log.pop();
        this.answer.setCharAt(node.num, 'O');
        if(node.pre!=null){
            node.pre.next = node;
        }
        if(node.next!=null){
            node.next.pre = node;
        }

    }
}