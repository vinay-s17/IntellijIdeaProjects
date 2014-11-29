package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 10/15/2014
 * <br />Time: 8:07 PM
 */
public class RdAndChand
{
	RdChandParser parser = new RdChandParser(System.in);
	public static void main(String[] args) throws Exception
	{
		new RdAndChand().proc();
	}
	public  void proc() throws Exception
	{
		int n = parser.nextInt();
		int sum = 0;
		int[] ip = new int[n];
		for(int i=0;i<n;i++)
		{
			ip[i] = parser.nextInt();
			sum += ip[i];
		}
		System.out.println(sum);
		float s1 = sum/3;
		System.out.println(sum/3);
		System.out.println((int)Math.ceil(s1));
	}

	public void process() throws Exception
	{
		//System.out.println(Math.pow(2,3));
		int t = parser.nextInt();
		while(t-- >0)
		{
			int sum = 0;
			String ip = parser.nextString();
			char[] ipChars = ip.toCharArray();
			//System.out.println(ipChars[1] == ipChars[0]);
			for(int i=(ipChars.length-1);i>0;i--)
			{
				for(int j = i-1; j >=0 ; j--)
				{
					if(ipChars[i] == ipChars[j])
					{
						sum += (int) Math.pow(2,(i-j));
						break;
					}
				}
			}
			BigInteger in= new BigInteger("100000007");
			BigInteger op = new BigInteger(String.valueOf(sum));
			System.out.println(op.mod(in));
			in = null;
			op=null;
		}


	}

}

class RdChandParser
{

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public RdChandParser(InputStream in)
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