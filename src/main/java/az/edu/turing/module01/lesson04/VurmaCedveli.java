package az.edu.turing.module01.lesson04;

public class VurmaCedveli {
    public static void main(String[] args) {
        for(int i = 1; i<10; i++){
            for(int j = 1; j<10; j++){
                int h = i*j;
                System.out.println(i + "*" + j + "=" + h);
            }
            System.out.println();
        }
    }
}