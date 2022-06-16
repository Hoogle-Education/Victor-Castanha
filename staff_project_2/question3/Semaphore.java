package question3;

public class Semaphore{
	int state;
	
	public Semaphore(int size){
		state = size;
	}
		
	//synchronized ensures this method is only ran by one thread at a single instance of time
	public synchronized void acquire(){
		while(state==0){
			try{
				//Thread.sleep(1000);
				wait(); // any threads running this method must wait until they are notified they can run again
			}catch(InterruptedException e){}
		}
		state--;
	}

	public synchronized void release(){
		state++;
		notify();
	}

}