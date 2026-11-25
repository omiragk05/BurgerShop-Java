/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgershop;

public class List {
    private Node first;
    
    public boolean add(int index, Burger burger){
        if(index>=0 && index<=size()){
            Node node=new Node(burger);
            if(index==0){
                node.next=first;
                first=node;
            }else{
                int count=0;
                Node temp=first;
                while(count<index-1){
                    temp=temp.next;
                    count++;
                }
                node.next=temp.next;
                temp.next=node;
            }
            return true;
        }
        return false;
    }
    public boolean addFirst(Burger burger){
        return add(0, burger);
    }
    public boolean addLast(Burger burger){
        return add(size(), burger);
    }
    public boolean add(Burger burger){
        return addLast(burger);
    }
    public boolean remove(int index){
        if(index>=0 && index<size()){
            if(index==0){
                first=first.next;
                return true;
            }else{
                int count=0;
                Node temp=first;
                while(count<index-1){
                    count++;
                    temp=temp.next;
                }
                temp.next=temp.next.next;
                return true;
            }
        }
        return false;
    }
    public boolean removeFirst(){
        return remove(0);
    }
    public boolean removeLast(){
        return remove(size()-1);
    }
    public int size(){
        int count=0;
        Node temp=first;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public void printBurgers(){
        System.out.print("{");
        Node temp=first;
        while(temp!=null){
            Burger burger=temp.burger;
            System.out.print(burger.toString()+", ");
            temp=temp.next;
        }
        System.out.println(isEmpty() ? "empty}":"\b\b}");
    }
    public boolean isEmpty(){
        return first==null;                
    }
    public Burger get(int index){
        if(index>=0 && index<size()){
            int count=0;
            Node temp=first;
            while(count<index){
                count++;
                temp=temp.next;
            }
            return temp.burger;
        }
        return null;
    }
    public Burger getFirst(){
        return get(0);
    }
    public Burger getLast(){
        return get(size()-1);
    }
    public int indexOf(Burger burger){
        if(burger==null){
            return -1;
        }
        int index=0;
        Node temp=first;
        while(temp!=null){
            if(burger.equals(temp.burger)){
                return index;
            }
            index++;
            temp=temp.next;
        }
        return -1;
    }
    public boolean contains(Burger burger){
        return indexOf(burger)!=-1;
    }
    public boolean remove(Burger burger){
        int index=indexOf(burger);
        return remove(index);
    }
    
    public void set(int index, Burger burger) {
    if (index >= 0 && index < size()) {
        int count = 0;
        Node temp = first;
        while (count < index) {
            temp = temp.next;
            count++;
        }
        temp.burger = burger;
    }
}


    
    class Node{
        private Burger burger;
        private Node next;
        public Node(Burger burger){
            this.burger=burger;
        }
    }    
}

