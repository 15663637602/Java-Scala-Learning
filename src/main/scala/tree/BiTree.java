package tree;

public class BiTree {
    private int v;
    private BiTree l;
    private BiTree r;

    private BiTree(int value){
        v = value;
    }

    private void add(BiTree newTree){
        if(newTree.v < this.v){
            if(l == null) l = newTree;
            else l.add(newTree);
        }else {
            if(r == null) r = newTree;
            else r.add(newTree);
        }
    }
    // Inorder Traversal else: Preorder, Postorder
    private void inorder(){
        if(l != null) l.inorder();
        System.out.println(v);
        if(r != null) r.inorder();
    }

    public static void main(String[] args) {
        BiTree t = new BiTree(10);
        t.add(new BiTree(5));
        t.add(new BiTree(13));
        t.add(new BiTree(21));
        t.add(new BiTree(17));
        t.add(new BiTree(15));
        t.add(new BiTree(18));
        t.add(new BiTree(54));
        t.inorder();
    }

}
