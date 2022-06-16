package question3;

public class Producer implements Runnable, Comparable<Producer>{

	Buffer buffer;
	int id;

	public Producer(Buffer buffer, int id)
	{
		this.buffer=buffer;
		this.id = id;
	}

	public void run()
	{
		while(true)
		{
			String item = "Item from #" + id;
			System.out.println(item);
			buffer.insert(item);
			System.out.println("Producer " + id + " successfully wrote to the buffer");
			try{
							Thread.sleep(2000);
			} catch(InterruptedException e){}
		}
	}

	@Override
	public int compareTo(Producer o) {
		return Integer.compare(id, o.id);
	}

}