package HackerEarth;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 10/4/2014
 * <br />Time: 2:54 PM
 */

import java.io.DataInputStream;
import java.io.InputStream;

public class KaranPrime1
{
	static PrimeParser obj = new PrimeParser(System.in);
	boolean primes[] = new boolean[2];
	int upper;
	int lower;

	public KaranPrime1() throws Exception
	{
		getBoundaries();
		primes = new boolean [upper+1];
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}

		processSieve();
		showPrimes();
	}

	public void processSieve()
	{
		for(int i = 2; (i * i) <= upper; i++ ){
			for (int j = (i * i); j <= upper; j = j + i) {
				primes[j] = false;
			}
		}
	}
	public void getBoundaries () throws Exception
	{
		lower = 0;
		upper = obj.nextInt();
	}

	public void showPrimes ()
	{
		int min=0;
		for (int i = 0; i <= upper; i++)
		{
			if(primes[i]==true)
			{
				for(int j=(i+1);j<=upper ;j++)
				{
					if(primes[j]==true && (i*j)==upper)
					{
						min = i;
						break;
					}
				}
			}
		}
		if (min > 0)
			System.out.println(upper - min);
		else
			System.out.println(min);

	}
	public static void main(String args[]) throws Exception
	{
		//Scanner in = new Scanner(System.in);
		int testCase = obj.nextInt();
		while (testCase--> 0)
		{
			new KaranPrime1();
		}

	}
}
class PrimeParser
{

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public PrimeParser(InputStream in)
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