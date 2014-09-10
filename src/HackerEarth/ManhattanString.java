package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 8/30/2014
 * <br />Time: 2:17 PM
 */
public class ManhattanString
{
	ManhattanParser parser= new ManhattanParser(System.in);

	public static void main(String[] args) throws Exception
	{
		new ManhattanString().Solve();
	}
	public void Solve() throws Exception
	{
		int testCase = parser.nextInt();
		while(testCase-- >0)
		{
			int even = 0;
			int odd= 0;
			int row = parser.nextInt();
			int col = parser.nextInt();
			for(int i=1;i<=row;i++)
			{
				if(i%2==0)
				{
					even += i;
					if(i > col)
						even = even - (i- col);
				}
				else
				{
					odd += i;
					if(i > col)
						odd = odd - (i - col);
				}
			}
			System.out.println(even + " " + odd);
		}
	}
}


class ManhattanParser {

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public ManhattanParser(InputStream in) {
		din = new DataInputStream(in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String nextString() throws Exception {
		StringBuffer sb = new StringBuffer("");
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		do {
			sb.append((char) c);
			c = read();
		} while (c > ' ');
		return sb.toString();
	}

	public char nextChar() throws Exception {
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		return (char) c;
	}

	public int nextInt() throws Exception {
		int ret = 0;
		byte c = read();
		while (c <= ' ') {
			c = read();
		}
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		return ret;
	}

	private void fillBuffer() throws Exception {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1) {
			buffer[0] = -1;
		}
	}

	private byte read() throws Exception {
		if (bufferPointer == bytesRead) {
			fillBuffer();
		}
		return buffer[bufferPointer++];
	}
}