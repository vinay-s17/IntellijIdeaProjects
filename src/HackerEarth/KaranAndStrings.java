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
 * <br />Time: 7:39 PM
 */
public class KaranAndStrings
{
	public static void main(String[] s)
	{
		try
		{
			InputStream inputStream = System.in;
			InputReaderK in = new InputReaderK(inputStream);
			PrintWriter writer = new PrintWriter(System.out);

			TaskAA solution = new TaskAA();
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

class TaskAA
{
	public void solve(InputReaderK in, PrintWriter out) throws IOException
	{
		int testCase = in.nextInt();
		while (testCase-->0)
		{
			String input = in.next();
			StringBuilder sb = new StringBuilder();
			sb.append(input.charAt(0));

			for(int i=1;i<input.length();i++)
			{
				if(input.charAt(i) != input.charAt(i-1))
					sb.append(input.charAt(i));
			}
			out.println(sb.toString());
		}
	}
}

class InputReaderK
{
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReaderK(InputStream stream)
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
