/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import java.util.Scanner;
import java.util.Stack;


public class JavaApplication1 {
    public static int rows;
    public static int columns;
    public static char[][] board;
    public static int[] end;
            
    public static Stack<int[]> positionStack = new Stack<int[]>();
    
    public static void moveLocation(int row, int column, int horizontal_units, int vertical_units) {
        if(column + horizontal_units >= 0 && column + horizontal_units < columns && row + vertical_units >= 0 && row + vertical_units < rows) {
        int[] newPosition = new int[2];
        newPosition[0] = row + vertical_units;
        newPosition[1] = column + horizontal_units;
        if( board[ newPosition[0]   ][  newPosition[1]   ] != '#' ) {
            positionStack.push(newPosition);
            }
        
        }    
    }
    
    
    
    public static void getPossibleLocations(int row, int column) {  
        moveLocation(row, column , 1, 2 );
        moveLocation(row, column , -1, 2 );
        moveLocation(row, column , 1, -2 );
        moveLocation(row, column , -1, -2 );
        
        moveLocation(row, column , 2, 1 );
        moveLocation(row, column , -2, 1 );
        moveLocation(row, column , 2, -1 );
        moveLocation(row, column , -2, -1 );
    }
    
    public static boolean goalFound() {
        Stack<int[]> temp = new Stack<>();
        
        while(positionStack.empty() == false) {
            int[] element = positionStack.pop();
              temp.push(element);
              
              if( (element[0] == end[0]) && (element[1] == end[1]) ) {
                  return true;
              }
          }
        
        while(temp.empty() == false) {
            int[] element = temp.pop();
              positionStack.push(element);
             
          }
        return false;
    }
            
            
            
    public static void main(String[] args) {
     Scanner x = new Scanner(System.in);
     String[] arrayDimensions = x.nextLine().split(" ");
     rows = Integer.parseInt(arrayDimensions[0]);
     columns = Integer.parseInt(arrayDimensions[1]);
     
     int numberOfMoves = 0;
     int[] start = new int[2];
     end = new int[2];
     
     
     System.out.println(rows);
     board = new char[rows][columns];
     
     for(int i = 0; i < rows; i++) {
         String currentString = x.nextLine();
         for(int j = 0; j < columns; j++) {
             board[i][j] = currentString.charAt(j);
         }
     }
     
     for(int i = 0; i < rows; i++) {
         for(int j = 0; j < columns; j++) {
             if( board[i][j] == 'S') {
                 start[0] = i;
                 start[1] = j;
             }
             if(board[i][j] == 'T') {
                 end[0] = i;
                 end[1] = j;
             }
             
         }
     }
     
     getPossibleLocations( start[0], start[1]);
     numberOfMoves++;
     
     while(goalFound() == false) {
         
         if(positionStack.empty() == true) {
             numberOfMoves =  -1;
             break;
         }
         
         
         
          Stack<int[]> temp_stack = new Stack<int[]>();
          
          while(positionStack.empty() == false) {
              temp_stack.push(positionStack.pop());
          }
          
          while(temp_stack.empty() == false) {
              int[] tem = temp_stack.pop();
              getPossibleLocations(tem[0], tem[1]);
          }
         numberOfMoves++;
     }
     
     System.out.println(numberOfMoves);
   
       
    }
    
}
