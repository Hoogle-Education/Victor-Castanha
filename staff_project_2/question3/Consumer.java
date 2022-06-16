package question3;

public class Consumer implements Runnable
{
	Buffer buffer;
	int id;

	public Consumer(Buffer buffer, int id)
	{
		this.buffer = buffer;
		this.id=  id;
	}

	public void run()
	{
		while(true)
		{
			String item = (String) buffer.remove();
			System.out.println("I am consumer number " + id + " and I successfully read from the buffer:" + item);

			try{
				Thread.sleep(2000);
			} catch(InterruptedException e){}

		}
	}

}