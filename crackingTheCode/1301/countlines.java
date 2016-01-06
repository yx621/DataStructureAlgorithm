import edu.princeton.cs.algs4.Queue;

public class countlines
{
	

	public static void main(String[] args) 
	{
		int k = Integer.parseInt(args[0]);

		String filename = args[1];

		In in = new In(filename);

		Queue<String> strQueue = new Queue<String>();

		while(in.hasNextLine())
		{
			String newLine = in.readLine();
			strQueue.enqueue(newLine);
			if(strQueue.size() > k)
			{
				strQueue.dequeue();
			}
		}

		System.out.println("The last " + k + " lines are ");

		while(strQueue.size() > 0)
		{
			System.out.println(strQueue.dequeue());
		}
	}
}