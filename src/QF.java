import edu.princeton.cs.algs4.StdIn;

public class QF {

 private int[] id;
 private int count;
 /**maybe need RETURN?*/
    public QF(int n){
        count = n;
        id = new int[n];
        for (int i=0; i<n; i++)
            id[i] =i;
    }

    public int count(){
        return count;
    }


    /**коннект завершил*/
    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }

    /**Union done*/
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i<id.length; i++){
            if(id[i] == pid) id[i] = qid;
        }
        count--;
    }

    /**dont touch*/
           public static void main(String[] args) {
               int n = StdIn.readInt();
               QF uf = new QF(n);
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
