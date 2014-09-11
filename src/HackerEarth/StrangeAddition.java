package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 9/11/2014
 * <br />Time: 7:32 PM
 */
public class StrangeAddition
{
	AddParser parser = new AddParser(System.in);

	public static void main(String[] args) throws Exception
	{
		new StrangeAddition().solve();
	}

	public void solve() throws Exception
	{
		//StrangeAddition obj = new StrangeAddition();
		int testCase = parser.nextInt();

		while(testCase-- >0)
		{
			int ip1 = parser.nextInt();
			int ip2 = parser.nextInt();

			int ip1Temp = StrangeAddition.reverseOfNumbers(ip1);
			int ip2Temp = StrangeAddition.reverseOfNumbers(ip2);

			int total = ip1Temp + ip2Temp;
			System.out.println(StrangeAddition.reverseOfNumbers(total));
		}
	}
	public static int reverseOfNumbers(int input)
	{
		int reverse = 0;
		while (input != 0 )
		{
			reverse *= 10 ;
			reverse += (input%10);
			input /=10;
		}
		return  reverse;
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