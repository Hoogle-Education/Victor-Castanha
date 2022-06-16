package question3;

public class BoundedBufferSimulation
{
	public static void main(String args[])
	{

		Buffer buffer = new Buffer(5);

		Thread c1 = new Thread(new Consumer(buffer, 1));

		Thread p1 = new Thread(new Producer(buffer, 1));
		Thread p2 = new Thread(new Producer(buffer, 2));
		Thread p3 = new Thread(new Producer(buffer, 3));
		Thread p4 = new Thread(new Producer(buffer, 4));
		Thread p5 = new Thread(new Producer(buffer, 5));

		c1.start();

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}
}