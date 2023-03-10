/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(Boo x) {
        Node node = new Node(x);

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    void addLast(String xForest, int xRate, int xSound) {
        //You should write here appropriate statements to complete this function.
        if (xForest.charAt(0) == 'A') {
            return;
        }
        addLast(new Boo(xForest, xRate, xSound));
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    void insertAt(Boo boo, int pos) {
        Node node = new Node(boo);
        int i = 1;
        Node p = head;
        while ((p.next != null) && (i + 1 < pos)) {
            p = p.next;
            i++;
        }

        node.next = p.next;
        p.next = node;

    }
//==================================================================

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Boo x, y;
        x = new Boo("X", 1, 2);
        y = new Boo("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insertAt(y, 2);
        insertAt(x, 3);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void deleteAt(int pos) {
        if (head == null) {
            return;
        } else {
            if (pos <= 1) {
                head = head.next;
                return;
            } else{
                Node node = head;
                int i = 1;
                while (node.next != null && i + 1 < pos) {
                    node = node.next;
                    i++;
                }
                Node del = node.next;
                if (del == null) {
                    tail = node;
                    return;
                }
                node.next = del.next;
            }
        }
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteAt(3);
        deleteAt(2);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    void sortBySound(int n) {
        Node[] array = new Node[n];
        int i = 0;
        Node node = head;
        while (i < n) {
            array[i] = node;
            i++;
            node = node.next;
        }
        
        for (i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i].info.sound > array[j].info.sound) {
                    Boo x = array[i].info;
                    array[i].info = array[j].info;
                    array[j].info = x;
                }
                
            }
        }
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sortBySound(5);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
