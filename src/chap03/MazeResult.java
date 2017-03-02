package chap03;

//*****************************************
// 迷宫求解问题
//*****************************************

class Point  // 通道块
{
	int x;          // 横坐标
	int y;          // 纵坐标
	int direction;  // 从此通道块走向下一通道块的“方向”，1 2 3 4 分别代表  右  下  左  上

	public void setDirection(int direction) 
	{
		this.direction = direction;
	}

	public Point(int xx,int yy,int direct)	// 构造函数
	{
		this.x = xx;
		this.y = yy;
		this.direction = direct;
	}
}

public class MazeResult   // 纯静态
{   
	// 迷宫,10*10,最外面一层为墙       1代表墙，即不通，0代表路可走，2代表已走过的通道块，3代表走过但已回退的通道块 
	static final int [][] MAZE = 
		   {{1,1,1,1,1,1,1,1,1,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,0,0,1,1,0,0,1},
            {1,0,1,1,1,0,0,0,0,1},
            {1,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,0,1},
            {1,0,1,1,1,0,1,1,0,1},
            {1,1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}};
	                                                
	static SqStack MAZEPATH = new SqStack();        // 存储探索的路径，存储一个一个的Point对象
	
	// 判断是否到达终点     静态     也不知道静态好不好？？？
	public static boolean arrive()
	{
		if( ((Point)MAZEPATH.getTop()).x==8 && ((Point)MAZEPATH.getTop()).y==8 )
		    return true;
		else
			return false;
	}
	
	// 打印路径
    public static void printMazePath()
    {
    	for(int i=0; i<10;i++)
    	{
    		for(int j=0;j<10;j++)
    		{
    			System.out.print(MAZE[i][j]);
    		}
    		System.out.println();
    	}
    }
	
	public static void main(String[] args)
	{
		int[][] move = {{0,1},{1,0},{0,-1},{-1,0}}; // 四个不同探索方向上横纵坐标的变换
		
	    Point p = new Point(1,1,1);   // 起点，先设置方向为1——右
	    MAZEPATH.push(p);             // 起点入栈
	    
	    // 探索迷宫
	    while( !(MAZEPATH.isEmpty()) ) // 循环条件：栈不为空（此处站若为空则证明已经后退到起点）
	    {
	    	int x = ((Point)MAZEPATH.getTop()).x;            // 当前位置的横坐标
	    	int y = ((Point)MAZEPATH.getTop()).y;            // 当前位置的纵坐标
	    	int d = ((Point)MAZEPATH.getTop()).direction;    // 当前位置的前进方向
	    	
	    	// 逐个试探4个方向
	    	while(d <= 4)
	    	{
	    		// 根据方向计算下一位置的坐标值
	    		int tempx = x + move[d-1][0];
	    		int tempy = y + move[d-1][1];
	    		
	    		if(MAZE[tempx][tempy] == 0) // 可达
	    		{	    			
	    			// 改变当前位置的前进方向
	    			((Point)MAZEPATH.getTop()).direction = d; 
	    			
	    			// 添加新的位置到栈中
	    			p = new Point(tempx,tempy,1); 
	    			MAZEPATH.push(p);
	    			System.out.println(p.x + "  " + p.y);
	    			
	    			// 将迷宫中新位置处置为2，表示已经通过	   
	    			MAZE[tempx][tempy] = 2;  			
	    			
	    			if(arrive()) // 判断是否已经到达终点
	    			{
	    				System.out.println("找到出口了！");
	    				
	    				printMazePath(); // 打印整个路径
	    				
	    				return;
	    			}
	    			
	    			break; // 跳出   while(d <= 4)
	    		}
	    		else // 变换方向
	    		{
	    			d++;
	    		}
	    	}
	    	// 周围4个方向都走不通
	    	if(d == 5) 
	    	{
	    		MAZE[x][y] = 3; // 将迷宫中当前位置处置为3，3代表走过但已回退的通道块 
	    		MAZEPATH.pop();
	    		
	    	}
	    }
	    
	    System.out.println("未找到出口！");
	}
}
