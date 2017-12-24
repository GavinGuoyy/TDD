import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	private static Client cl=new Client();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFind() {
		int [][]a={ {0,0,0,0,0},
					{0,0,0,1,0},
					{0,1,0,1,0},
					{0,0,1,1,0},
					{0,0,0,0,0}};
		int x=cl.Find(a, 5, 5, 2, 4);
		assertEquals(3,x);
		//fail("Not yet implemented");
	}

	@Test
	public void testSolve() {
		//“滑翔者”：每4个回合“它”会向右下角走一格。虽然细胞早就是不同的细胞了，但它能保持原本的形态。
		int [][]a={ {0,0,0,0,0},
					{0,0,0,1,0},
					{0,1,0,1,0},
					{0,0,1,1,0},
					{0,0,0,0,0}};
		int [][]b={ {0,0,0,0,0},
					{0,0,0,0,0},
					{0,0,0,0,1},
					{0,0,1,0,1},
					{0,0,0,1,1}};
		cl.solve(a, 5, 5);
		cl.solve(a, 5, 5);
		cl.solve(a, 5, 5);
		cl.solve(a, 5, 5);
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				assertEquals(b[i][j],a[i][j]);
			}
		}
		//fail("Not yet implemented");
	}

}
