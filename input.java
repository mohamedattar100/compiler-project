import java.io.*;
public class input {
    public static void main(String[] args) throws Exception{
        int x=5;
        if(x==5) {
            System.out.println(x);
            for (int i = 0; i < x; i++) {
                    System.out.println(i);
            }
            for (int i = 10; i > x; i--) {
                System.out.println(i);
            }

        }
        else if(x==10){
            System.out.println(x);
            for (int i = 0; i < x; i++) {
                System.out.println(i);
            }
            for (int i = 20; i > x; i--) {
                System.out.println(i);
            }
        }
        else{
            System.out.println("else");

        }



    }
}
