import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UF {
    /*
    * number of components
    * */
    private int count;
    private int[] componentIds;

    /*
    * initialize union-find data structure with N objects (0 to N – 1)
    * */
    public UF(int N){
        count = N;
        componentIds = new int[N];
        for(int i = 0; i < N; i++){
            componentIds[i] = i;
        }
    }


    /*
    * add connection between p and q
    * */
    public void union(int p, int q){
       int pId = find(p);
       int qId = find(q);

       if(pId == qId){
           return;
       }

       for(int i = 0; i < componentIds.length; i++){
           if(componentIds[i] == pId){
               componentIds[i] = qId;
           }
       }
       count--;
    }

    /*
    * are p and q in the same component?
    * */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /*
    * component identifier for p (0 to N – 1)
     * */
    public int find(int p){
        return componentIds[p];
    }

    /*
    * number of components
    * */
    public int count(){
        return count;
    }

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\Repository\\Algorithms-Princeton\\Codes\\test\\tinyUF.txt"));
            String str = in.readLine();
            int n = Integer.parseInt(str);
            UF uf = new UF(n);
            while((str = in.readLine()) != null){
                int p = Integer.parseInt(str.split(" ")[0]);
                int q = Integer.parseInt(str.split(" ")[1]);
                if(uf.find(p) == uf.find(q)){
                    continue;
                }
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
            System.out.println(uf.count() + " components");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
