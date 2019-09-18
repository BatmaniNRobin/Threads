public class SynchQueue{
	
	private int size;
	private IntNode front;
	private IntNode back;
	private boolean done;
	
	public SynchQueue(){
		front = back = null;
		this.done = false;
		this.size = 0;
	}
	
	public synchronized int getSize(){
		return size;
	}
	
	public boolean isFull(){
		if (size >= 10){
			done = true;
			return done;
		}
		return done;
	}
	
	public synchronized boolean enqueue(int datum){
		if (isFull()){return false;}
		
		IntNode nnode = new IntNode(datum);
		if (size == 0 && size <10){
			nnode.setNode(front);
			front = nnode;
			size++;
			if (back == null){back = front;}
			return true;
		}
		IntNode current = front;
		int cInd = 0;
		
		while (current != null && cInd < 10){
			current = current.getNext();
			cInd++;
		}
		if (current == null && size < 10){
			size++;
			if (back == null){
				back = front = nnode;
				return true;
			}else{
				back.setNode(nnode);
				back = nnode;
				return true;
			}
		}else if (size < 10){
			IntNode temp = current.getNext();
			size++;
			current.setNode(nnode);
			nnode.setNode(temp);
			return true;
		}
		return true;
	}
	
	public synchronized int dequeue(){
		if (front == null){
			return -1;
		}
		IntNode current = front;
		front = front.getNext();
		size--;
		return current.getData();
	}
	
	public boolean isDone(){
		return done;
	}
	
	public void shutdown(){
		done = true;
	}
}