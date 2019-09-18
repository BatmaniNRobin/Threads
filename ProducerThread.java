import java.util.Random;

public class ProducerThread extends Thread{
	
	private int index;
	private SynchQueue sq;
	
	public ProducerThread(int ind, SynchQueue queue){
		index = ind;
		sq = queue;
	}
	
	public void run(){
		Random r = new Random();
		// int j = r.nextInt(11);
		 while(sq.isDone() != true){
			sq.enqueue(r.nextInt(11));
			try{
				this.sleep(200);
			}catch(InterruptedException e){}
			System.out.println("Producer "+index+" added "+r.nextInt(11)+", queue size is "+sq.getSize());
		}
	}
}