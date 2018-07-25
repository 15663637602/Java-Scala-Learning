package tree;

// 红黑树 一般插入 都是插入红色结点, 如果插入黑色，会导致黑高度不合法
public class RBTree<Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key; // key
        private Value val;
        private Node left, right;
        private boolean color; // The color of the link to its parent node.
        private int size; // The number of the nodes of its sub tree.

        public Node(Key key, Value val, boolean color, int size){
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    public RBTree(){

    }

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.size;
    }

    public int size(){
        return size(root);
    }

    private boolean isEmpty(){
        return root == null;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("argument is not exist");
        return get(root, key);
    }

    private Value get(Node p, Key key){
        while (p != null){
            if(key.compareTo(p.key) == 0) return p.val;
            else if (key.compareTo(p.key) < 0){
                p = p.left;
            }else p = p.right;
        }
        return null;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color; // 与父节点颜色也要和之前的 h 与父节点的颜色相同
        x.left.color = RED; // 左边变成红链接
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h){
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public void put(Key key, Value val){
        if(key == null || val == null) throw new IllegalArgumentException("empty input value");

        root = put(root, key, val);
        // 根一定为黑色
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if(h == null) return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.val = val; // key重复了，就当做更新操作

        if(isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))
            flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node p){
        if(p == null) return 0;
        else {
            int lh = getHeight(p.left);
            int rh =getHeight(p.right);
            return Math.max(lh, rh) + 1;
        }
    }
}
