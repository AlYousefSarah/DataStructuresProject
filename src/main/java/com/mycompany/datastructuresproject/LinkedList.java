package com.mycompany.datastructuresproject;

 class Node<T> {
public T data;
public Node<T> next;
public Node () {
data = null;
next = null;
}
public Node (T val) {
data = val;
next = null;
}
}

public class LinkedList<T>{
private Node<T> head;
private Node<T> current;
int size = 0;
public LinkedList () {
head = current = null;
}
public boolean empty () {
return head == null;
}
public boolean last () {
return current.next == null;
}
public boolean full () {
return false;
}
public void findfirst () {
current = head;
}
public void findnext () {
current = current.next;
}
public T retrieve () {
return current.data;
}
public void update (T val) {
current.data = val;
}
public void insert (T val) {
Node<T> tmp;
if (empty()) {
current = head = new Node<T> (val);
}
else {
tmp = current.next;
current.next = new Node<T> (val);
current = current.next;
current.next = tmp;
}
size++;
}
public void remove () {
if (current == head) {
head = head.next;
}
else {
Node<T> tmp = head;
while (tmp.next != current)
tmp = tmp.next;
tmp.next = current.next;
}
if (current.next == null)
current = head;
else
current = current.next;
size--;
}

public void display (){
   if (head==null)
System.out.println ("empty list");
Node<T>p=head;
while (p!=null){
System.out.print (p.data+" "); 
p=p.next;
System.out.println ("\n------------");
}
System.out.println ("num of items="+size);
}

public void insert_befor_current(T val){
 Node<T> tmp = new Node<> (val);
 if(head==null){
     head=current=tmp;
 }
 else if(current==head) {
     tmp.next=head;
     head=tmp;
 } 
 else{
     Node<T> p = head;
     while(p.next!= current){
         p=p.next;
     }
     p.next=tmp;
     tmp.next=current;
 }  
 size++;   
}


   public static void main (String[] args) {
LinkedList<Integer> list = new LinkedList<>();
System.out.println ("Is Empty: " + list.empty ()) ;
list. insert (10);
list.insert (20);
list.insert (30) ;
System.out.print ("After insert: "); 
list.display();
list.findfirst ();
System.out.println("\nFirst Element: " + list. retrieve ());
list.findnext () ;
System.out.println("second Element: " + list. retrieve ()); 
list.update (25) ;
System. out.print ("After update second to 25: "); 
list.display();
list.findnext ();
System.out.println("\nIs Last: " + list.last ());
list.insert_befor_current(27);
System.out.println("\nIs currenmtyvf: " );
list.display();
list. remove () ;
System.out.print ("\nAfter remove last : "); 
list.display();
list.findfirst ();
list.remove ();
System. out.print ("\nAfter removing head: "); 
list.display();
System.out.println("\nIs Empty: " + list.empty ());
}
}