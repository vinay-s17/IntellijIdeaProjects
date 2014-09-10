package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 9/10/2014
 * <br />Time: 9:55 PM
 */

public class Solution
{
	JParser parser= new JParser(System.in);

	public static void main(String[] args) throws Exception
	{
		new Solution().Solve();
	}
	public void Solve() throws Exception
	{
		int t = parser.nextInt();
		while(t-- >0)
		{
			String ip = parser.nextString();
			char[] ipAsChar = ip.toCharArray();
			int count = 0;
			for(int i=1;i<ipAsChar.length;i++)
			{
				if(ipAsChar[i] == ipAsChar[(i-1)])
					count++;
			}
			System.out.println(count);
		}
	}
}


class JParser {

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public JParser(InputStream in) {
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