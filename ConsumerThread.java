public class ConsumerThread extends Thread{
	
	private int index;
	private SynchQueue sq;
	
	public ConsumerThread(int ind, SynchQueue queue){
		index = ind;
		sq = queue;
	}
	
	public void run(){
		while (sq.isDone() == false){
			while (sq.dequeue() == -1){
				try{
					sq.dequeue();
					this.sleep(800);
				}catch(InterruptedException e){}
			}
			int j = sq.dequeue();
			int fact = 1;
			for (int i = 1; i<=j; i++){
				fact = fact * i;
			}
			System.out.println("Consumer " + index + " removed " + j +"! computed is: "+fact); 
			try{
				this.sleep(100);
			}catch(InterruptedException e){}
		} // do not know how to prevent deadlock
	} // do not know how to signal the notifying queue
}