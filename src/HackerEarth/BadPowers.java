package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 10/15/2014
 * <br />Time: 9:12 PM
 */
public class BadPowers
{

	public static void main(String[] args) throws Exception
	{
		new BadPowers().process();
	}
	public void process() throws Exception
	{
		//BadPowersParser parser = new BadPowersParser(System.in);
		//System.out.println(Math.pow(2,3));
		Scanner parser = new Scanner(System.in);
		int t = parser.nextInt();
		while(t-- >0)
		{
			int n = parser.nextInt();
			int sumOfPower = parser.nextInt();
			int[] series = new int[n];
			for(int i=0;i<n;i++)
			{
				series[i] = parser.nextInt();
			}
			String res = "No";
			for(int i=0;i<n;i++)
			{
				int tempSum = series[i];
				for(int j=1;j<n;j++)
				{
					tempSum +=  series[j];
					if(tempSum == sumOfPower)
					{
						res = "Yes";
						break;
					}
				}
				if(res.equals("Yes"))
					break;
			}

			System.out.println(res);
		}
	}

}

class BadPowersParser
{

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public BadPowersParser(InputStream in)
	{
		din = new DataInputStream(in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String nextString() throws Exception
	{
		StringBuffer sb = new StringBuffer("");
		byte c = read();
		while (c <= ' ')
		{
			c = read();
		}
		do
		{
			sb.append((char) c);
			c = read();
		}
		while (c > ' ');
		return sb.toString();
	}

	public char nextChar() throws Exception
	{
		byte c = read();
		while (c <= ' ')
		{
			c = read();
		}
		return (char) c;
	}

	public int nextInt() throws Exception
	{
		int ret = 0;
		byte c = read();
		while (c <= ' ')
		{
			c = read();
		}
		do
		{
			ret = ret * 10 + c - '0';
			c = read();
		}
		while (c > ' ');
		return ret;
	}

	private void fillBuffer() throws Exception
	{
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
		{
			buffer[0] = -1;
		}
	}

	private byte read() throws Exception
	{
		if (bufferPointer == bytesRead)
		{
			fillBuffer();
		}
		return buffer[bufferPointer++];
	}
}