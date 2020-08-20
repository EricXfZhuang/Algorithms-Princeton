import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickFindUF {
    private int id[];
    private int count;

    public QuickFindUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public int find(int p){
        return id[p];
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public int count(){
        return count;
    }

    public void union(int p, int q){
        int idP = find(p);
        int idQ = find(q);

        if(connected(p, q)) return;

        for(int i = 0; i < id.length; i++){
            if(id[i] == idP){
                id[i] = idQ;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\Repository\\Algorithms-Princeton\\Codes\\test\\tinyUF.txt"));
            String str = in.readLine();
            int n = Integer.parseInt(str);
            QuickFindUF uf = new QuickFindUF(n);
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
