package pertemuan15.tugas;

public class Graph14 {
    int vertex;
    doubleLL list[];

    public Graph14(int v){
        vertex = v;
        list = new doubleLL[v];
        for (int i = 0; i < v; i++) {
            list[i] = new doubleLL();
        }
    }

    public void addEdge(int asal, int tujuan, int jarak){
        list[asal].addFirst(tujuan, jarak);
    }
    //apabila graf yang dibuat adalah undirected graph, maka tambahkan kode berikut.
    // list[tujuan].addFirst(asal, jarak);

    public void degree(int asal) throws Exception{
        int k, totalIn = 0, totalOut = 0;
        for (int i = 0; i < vertex; i++) {
            //inDegree
            for (int j = 0; j < list[i].size(); j++) {
                if (list[i].get(j) == asal) {
                    ++totalIn;
                }
            }
            //outDegree
            for (k = 0; k < list[asal].size(); k++) {
                list[asal].get(k);
            }
            totalOut = k;
        }
        System.out.println("InDegree dari Gedung " + (char) ('A' +asal) + ": " + totalIn);
        System.out.println("OutDegree dari Gedung " + (char) ('A' +asal) + ": " + totalOut);
        System.out.println("Degree dari Gedung " + (char) ('A' +asal) + ": " + (totalIn + totalOut));

        //Apabila graf yang dibuat adalah undirected graph, maka cukup gunakan kode berikut.
        //System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + list[asal].size());
    }

    public void removeEdge(int asal, int tujuan) throws Exception{
        for (int i = 0; i < vertex; i++) {
            if (i == tujuan) {
                list[asal].remove(tujuan);
            }
        }
    }

    public void removeAllEdge(){
        for (int i = 0; i < vertex; i++) {
            list[i].clear();
        }
    }

    public void printGraph()throws Exception{
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                System.out.print("Gedung " + (char) ('A' + i) + " terhubung dengan ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print((char) ('A' + list[i].get(j)) + " (" + list[i].getJarak(j) + " m), ");
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }
    public boolean cekEdge(int asal, int tujuan) {
        Node14 current = list[asal].head;
        while (current != null) {
            if (current.data == tujuan) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void updateJarak(int asal, int tujuan, int jarak) throws Exception {
        Node14 current = list[asal].head;
        while (current != null) {
            if (current.data == tujuan) {
                current.jarak = jarak;
                return;
            }
            current = current.next;
        }
        throw new Exception("Edge tidak ditemukan");
    }

    public int hitungEdge() {
        int count = 0;
        for (int i = 0; i < vertex; i++) {
            count += list[i].size();
        }
        return count;
    }

} 