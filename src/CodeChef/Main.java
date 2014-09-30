package CodeChef;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * IIT ACM Problem
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 9/30/2014
 * <br />Time: 7:37 PM
 */
public class Main
{

	public static void main(String[] args) throws Exception
	{
		AddParser parser = new AddParser(System.in);
		int t = parser.nextInt();
		while(t-- >0)
		{
			int x = parser.nextInt();
			int n = parser.nextInt();
			int m = parser.nextInt();
			int res = ((1 - ((int)Math.pow(x,n))) / (1-x)) - 1;
			System.out.println(res % m);
		}
	}
}

class AddParser {

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public AddParser(InputStream in) {
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