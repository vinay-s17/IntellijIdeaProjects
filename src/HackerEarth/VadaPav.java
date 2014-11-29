package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 10/4/2014
 * <br />Time: 2:32 PM
 */
public class VadaPav
{
	VadaPavParser parser = new VadaPavParser(System.in);

	public static void main(String[] args) throws Exception
	{
		new VadaPav().solve();
	}

	public void solve() throws Exception
	{
		//StrangeAddition obj = new StrangeAddition();
		int n = parser.nextInt();
		TreeSet<String> al = new TreeSet<String>();
		String ip;
		for (int i = 0; i < n; i++)
		{
			ip = parser.nextString();
			al.add(ip);
			ip = null;
		}
		System.out.println(al.size());
		Iterator<String> itr = al.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

	class VadaPavParser
	{

		final private int BUFFER_SIZE = 1 << 17;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public VadaPavParser(InputStream in)
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
}
