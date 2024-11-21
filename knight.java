public class knight
{
	public static void print_sol(int[][] sol)
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(sol[i][j] + " ");
			}
		System.out.println();	
		}
	}
	public static boolean isSafe(int x, int y, int[][] sol)
	{
		if(x>=0 && y>=0 && y<8 && x<8 && sol[x][y] == -1)
		{
			return true;
		}
		return false;
	}
	public static boolean tour(int x, int y, int movei, int[][] sol, int[] movex, int[] movey)
	{
		if(movei == 64)
		{
			return true;
		}

		for(int i=0;i<8;i++)
		{
		
		  	int newx = x + movex[i];
			int newy = y + movey[i];
			if(isSafe(newx, newy, sol))

			{
				sol[newx][newy] = movei;
				if(tour(newx, newy, movei+1, sol, movex, movey))
				{
					return true;
				}
				else{
					sol[newx][newy]=-1;
				}
			}
		}
		return false;
	}



	public static void main( String[] args )
	{
		int[] xmove = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] ymove={1, 2, 2, 1, -1, -2, -2, -1};
		int[][] sol=new int[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				sol[i][j] = -1;
			}	
		}
		sol[0][0] = 0;
		if(tour(0, 0, 1, sol, xmove, ymove))
		{
			print_sol(sol);
		}
		else
		{
			System.out.println("No Solution Exist ");
		}


	}





}