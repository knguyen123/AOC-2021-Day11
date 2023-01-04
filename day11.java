import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class day11{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("flash.txt"));
      int[][] arr = new int[10][10];
      boolean[][] b = new boolean[10][10];
      int count = 0;
      int row = 0;
      String s = "";
      
      while(f.hasNext()){
         s = f.nextLine();
         for(int c = 0; c < 10; c++){
            arr[row][c] = Integer.parseInt(s.charAt(c)+"");
         }
         row++;
      }
      for(int i = 0; i < 100; i++){
         for(int r = 0; r < 10; r++){
            for(int c = 0; c <10; c++){
               count+= flash(arr,b,r,c);
               
            }
         }
         set0(arr,b);
         b = new boolean[10][10];
      }
      System.out.println(count);
      
   }
   public static int flash(int[][] arr, boolean[][] b, int r, int c){
      if(r<0||c<0||c>9||r>9){
         return 0;
      }else{
         arr[r][c]++;
         if(arr[r][c]>9&&!b[r][c]){
            b[r][c] = true;
            arr[r][c]=0;
            return 1+flash(arr,b,r+1,c)+flash(arr,b,r-1,c)+flash(arr,b,r,c+1)+flash(arr,b,r,c-1)+flash(arr,b,r+1,c+1)+flash(arr,b,r-1,c+1)+flash(arr,b,r+1,c-1)+flash(arr,b,r-1,c-1);
         }else{
            return 0;
         }
      }
      
   }
   public static void set0(int[][] arr, boolean[][] b){
      for(int r = 0; r < 10; r++){
         for(int c = 0; c < 10; c++){
            if(b[r][c]){
               arr[r][c]=0;
            }
         }
      }
   }
}