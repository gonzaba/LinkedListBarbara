package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		if(length==0) {
			first = last = (SNode<E>) nuevo;
		}
		else {
			((SNode<E>) nuevo).setNext(first);
			first = (SNode<E>) nuevo;
		}
		length++;
		
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		if(target == last) {
			last = (SNode<E>) nuevo;
		}
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo); 
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if(target==first) {
			this.addFirstNode(nuevo);
		}
		else {
			Node<E> prevNode = getNodeBefore(target);
			this.addNodeAfter(prevNode, nuevo);
			length++;
		}
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		SNode<E> node = ((SNode<E>) target).getNext(); 
		if (node == null)  
			throw new NoSuchElementException("Target is the last node. There is no more Nodes"); 
		else 
			return node;
	}

	public Node<E> getNodeBefore(Node<E> target) throws NoSuchElementException {
		if(target == first) throw new NoSuchElementException("target is the first node.");
		else {
			SNode<E> prev = first;
			while(prev!= null && prev.getNext() != target) {
				prev = prev.getNext();
			}
			return prev;
		}
		
	}

	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public void removeNode(Node<E> target) {
		if (target == first)
		{
			SNode<E> ntr = first; 
			first = first.getNext(); 
			ntr.setNext(null); 
		}
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
		}
		length--;	
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
