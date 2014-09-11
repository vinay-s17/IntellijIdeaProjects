package HackerEarth;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 9/11/2014
 * <br />Time: 8:04 PM
 */
public class InverseList
{
	//ILParser parser = new ILParser(System.in);
	// Class clashes bcas of main fn not in Parser
	public static void main(String[] args) throws Exception
	{
		new InverseList().solve();
	}
	public void  solve() throws Exception
	{
		Scanner parser = new Scanner(System.in);
		int testCase = parser.nextInt();
		while (testCase-- >0)
		{
			int size = parser.nextInt();
			int[] digits = new int[size];
			for(int i=0;i<size;i++)
			{
				digits[i] = parser.nextInt();
			}
			boolean isInverse = true;
			for (int i=0;i<size;i++)
			{
				if (digits[i] != digits[digits[i]-1])
				{
					isInverse = false;
					break;
				}
			}
			if(isInverse)
				System.out.println("inverse");
			else
				System.out.println("not inverse");
		}

	}
}
class ILParser {

	final private int BUFFER_SIZE = 1 << 17;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public ILParser(InputStream in) {
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