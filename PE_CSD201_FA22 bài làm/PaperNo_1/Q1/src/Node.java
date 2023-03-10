// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private CD info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (CD x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (CD x) {
        this(x,null);
    }
    
    public CD getInfo() {
        return this.info;
    }
    
    public void setInfo(CD inCala) {
        this.info = inCala;
    }
 }

