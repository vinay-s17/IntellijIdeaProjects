package HackerEarth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 8/25/2014
 * <br />Time: 7:26 PM
 */
public class KaranSticker
{
		public static void main(String[] s)
		{
			try
			{
				InputStream inputStream = System.in;
				InputReader in = new InputReader(inputStream);
				PrintWriter writer = new PrintWriter(System.out);

				TaskA solution = new TaskA();
				solution.solve(in,writer);

				writer.close();
				inputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

}

class TaskA
{
	public void solve(InputReader in, PrintWriter out) throws IOException
	{
		int testCase = in.nextInt();
		int count=0;
		while (testCase-- >0)
		{
			int num = in.nextInt();
			if(num < 300000000)
				count++;
		}
		out.println(count);
	}
}

class InputReader
{
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream)
	{
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next()
	{
		while (tokenizer == null || !tokenizer.hasMoreTokens())
		{
			try
			{
				tokenizer = new StringTokenizer(reader.readLine());
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt()
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}

	public double nextDouble()
	{
		return Double.parseDouble(next());
	}
}
