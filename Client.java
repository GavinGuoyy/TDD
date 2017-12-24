import java.util.Scanner;

public class Client {
	public static int [][]dir={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	public static int Find(int a[][],int n,int m,int i,int j)
	{
		int x,y,k,ret=0;
		for(k=0;k<8;k++)
		{
			x=i+dir[k][0];
			y=j+dir[k][1];
			if(x<0 || x>=n) continue;
			if(y<0 || y>=m) continue;
			if(a[x][y] == 1) ret++;
		}
		return ret;
	}
	public static void solve(int a[][],int n,int m)
	{
		int i,j,x;
		char [][]b=new char[n][m];
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				if(a[i][j]==1)
				{
					x=Find(a,n,m,i,j);
					if(x<2) b[i][j]=0;
					else if(x<=3) b[i][j]=1;
					else if(x>3) b[i][j]=0;
				}
				else
				{
					x=Find(a,n,m,i,j);
					if(x==3) b[i][j]=1;
					else b[i][j]=0;
				}
			}
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				a[i][j]=b[i][j];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,m,i,j;
		System.out.print("请输入初始细胞图的行列数：");
		n=sc.nextInt();
		m=sc.nextInt();
		int [][]a=new int[n][m];
		
		System.out.println("请输入初始细胞图（1表示存活细胞，0表示死亡细胞）：");
		for(i=0;i<n;i++)
		{
			String s=sc.next();
			for(j=0;j<m;j++)
			{
				a[i][j]=s.charAt(j)-'0';
			}
		}
		for(int ii=1;ii<=3;ii++)
		{
			System.out.println("第"+ii+"代细胞图：");
			solve(a,n,m);
			for(i=0;i<n;i++)
			{
				for(j=0;j<m;j++)
				{
					System.out.print(a[i][j]);
				}
				System.out.println("");
			}
		}
	}

}
