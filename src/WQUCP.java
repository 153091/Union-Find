import edu.princeton.cs.algs4.StdIn;

public class WQUCP {

 private int[] id;
 private int[] sz;
 private int count;
 
    public WQUCP(int n){
        count = n;
        id = new int[n];
        sz = new int[n]; //массив размером n
        for (int i=0; i<n; i++){
            id[i] =i;
            sz[i] = 1; }
    }

    public int count(){
        return count;
    }

    private int root(int i){
        while(i != id[i]) {
            id[i] = id[id[i]]; //берет на себя значение деда
            i = id[i];
        }
        return i;
    }

    /**коннект завершил*/
    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    /**Union done*/
    public void union(int p, int q){
        int rootp = root(p);
        int rootq = root(q);
        if (sz[rootp]<sz[rootq]) {id[rootp] = rootq; sz[rootq] += sz[rootp];}
        else             {id[rootq] = rootp; sz[rootp] = sz[rootq];}
        count--;
    }

    /**dont touch*/
           public static void main(String[] args) {
               int n = StdIn.readInt();
               WQUCP uf = new WQUCP(n);
               while (!StdIn.isEmpty()) {
                   int p = StdIn.readInt();
                   int q = StdIn.readInt();
                   if (!uf.connected(p, q)){
                       uf.union(p, q);
                       System.out.println(p + " " + q);
                   }
               }
                  System.out.println(uf.count() + " fucking components");

           }

}
