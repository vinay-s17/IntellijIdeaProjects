package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 10/16/2014
 * <br />Time: 9:07 PM
 */
public class Fact
{
	FactParser parser = new FactParser(System.in);
	public static void main(String[] args) throws Exception
	{
		new Fact().process();
	}
	public void process() throws Exception
	{
		//System.out.println(Math.pow(2,3));
		int t = parser.nextInt();
		while(t-- >0)
		{
			int n = parser.nextInt();
			BigInteger fact = BigInteger.valueOf(1);
			for (int i=2;i<=n;i++)
			{
				fact = fact.multiply(BigInteger.valueOf(i));
			}
			String ops = fact.toString();
			if(ops.length() <= 5)
				System.out.println(String.format("%05d",fact));
			else
			{
				char[] opsss= ops.toCharArray();
				//int end = opsss.length -1;
				for (int start = opsss.length - 5; start < opsss.length; start++)
				{
					System.out.print(opsss[start]);
				}
			}
		}
	}
}

class FactParser
{

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public FactParser(InputStream in)
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