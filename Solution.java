/******************************************************************************
RUN THE CODE HERE :: https://www.onlinegdb.com/online_java_compiler
*******************************************************************************/


public class Main
{   
    // int [][] directions = {{-1,0},{1,0},{0,-1},{0,1}}
    public static boolean dfs(int row, int col, String input, int index, char [][] board){
        
        if(index==input.length()-1){
            return true;
        }
        
        char temp = board[row][col];
        board[row][col] = '*';
        
         /* look in that col completely */
        for(int i=0; i<board.length;i++){
            if(board[i][col]==input.charAt(index+1)){
                if(dfs(i, col, input, index+1, board)){
                    return true;
                }
            }
                
        }
        
        /* look in that row first completely */
        for(int i=0; i<board.length;i++){
            if(board[row][i]==input.charAt(index+1)){
               if(dfs(row, i, input, index+1, board)){
                   return true;
               }
            }
        }
      
        board[row][col] = temp;
        return false;
        
    }
    
	public static void main(String[] args) {

        char [][] board = {
		    {'a', 'b', 'k', 'e'},
		    {'i', 'f', 'g', 'k'},
		    {'e', 'w', 'g', 'w'},
		    {'a', 'n', 'k', 'w'}
		};
		String input = "aegkk";
		
		boolean flag = false;
		for(int i=0;i<board.length;i++)
		    for(int j=0; j<board[i].length;j++){
		        if(board[i][j]== input.charAt(0)){
		            if(dfs(i, j, input, 0, board)){
		                System.out.println("VALID");
		                flag=true;
		                break;
		            }
		        }
		    }
		    
		    if(!flag)
                System.out.println("INVALID");

	}
}
