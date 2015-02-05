package Jmp;

// Mfilenode.java
public class Mfilenode {

    Mfile element;
    Mfilenode next;

    public Mfilenode(Mfile e, Mfilenode n) {
        element = e;
        next = n;
    }

    public Mfilenode(Mfile e) {
        this(e, null);
    }
}
