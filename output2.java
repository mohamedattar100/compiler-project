import java.io.*;
public class input {
 
 	 public static boolean check(int NoOfExpression) {
	 try{FileWriter w = new FileWriter("the_visited_exp.txt",true);
	  w.write("exp"+NoOfExpression+"is visited\n");
	 w.close();
}	 catch(Exception e){}
	 return false;
		 }

    public static void main(String[] args) {//block number 1
		try{
		File output = new File("output.txt");
		output.createNewFile();
		FileWriter w1 = new FileWriter("output.txt");
		w1.write("block 1 is Visited" +"\n");
		w1.close();
		}catch (IOException e) {throw new RuntimeException(e);}

        int x=5;
        if((check(1)||x==5)||(check(2)||x==3)) {//block number 2
		try{
		FileWriter w2 = new FileWriter("output.txt",true);
		w2.write("block 2 is Visited"+"\n");
		w2.close();
		}catch (IOException e) {throw new RuntimeException(e);}

            System.out.println(x);
            for (int i = 0; i < x; i++) {//block number 3
		try{
		FileWriter w3 = new FileWriter("output.txt",true);
		w3.write("block 3 is Visited"+"\n");
		w3.close();
		}catch (IOException e) {throw new RuntimeException(e);}

                    System.out.println(i);
            }
            for (int i = 10; i > x; i--) {//block number 4
		try{
		FileWriter w4 = new FileWriter("output.txt",true);
		w4.write("block 4 is Visited"+"\n");
		w4.close();
		}catch (IOException e) {throw new RuntimeException(e);}

                System.out.println(i);
            }

        }
        else if((check(3)||x==10)){//block number 5
		try{
		FileWriter w5 = new FileWriter("output.txt",true);
		w5.write("block 5 is Visited"+"\n");
		w5.close();
		}catch (IOException e) {throw new RuntimeException(e);}

            System.out.println(x);
            for (int i = 0; i < x; i++) {//block number 6
		try{
		FileWriter w6 = new FileWriter("output.txt",true);
		w6.write("block 6 is Visited"+"\n");
		w6.close();
		}catch (IOException e) {throw new RuntimeException(e);}

                System.out.println(i);
            }
            for (int i = 20; i > x; i--) {//block number 7
		try{
		FileWriter w7 = new FileWriter("output.txt",true);
		w7.write("block 7 is Visited"+"\n");
		w7.close();
		}catch (IOException e) {throw new RuntimeException(e);}

                System.out.println(i);
            }
        }
        else{//block number 8
		try{
		FileWriter w8 = new FileWriter("output.txt",true);
		w8.write("block 8 is Visited"+"\n");
		w8.close();
		}catch (IOException e) {throw new RuntimeException(e);}

            System.out.println("else");

        }



    }
}
