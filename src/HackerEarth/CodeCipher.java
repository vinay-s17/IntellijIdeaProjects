package HackerEarth;

import java.util.Scanner;

/**
 * <br />Created with IntelliJ IDEA.
 * <br />User: DesikaVinayagam S
 * <br />Date: 10/16/2014
 * <br />Time: 9:51 PM
 */
public class CodeCipher
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n-- >0)
		{
			int piza = in.nextInt();
			float minCut =(float) piza / 2;
			System.out.println((int)Math.ceil(minCut));
		}
	}
}
