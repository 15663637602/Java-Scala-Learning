package tree;


// Red Black Tree 左右高度相差不会超过2倍
public class AVLTree {
    private int v;
    private AVLTree l;
    private AVLTree r;
    private int balance = 0;

    public int getBalance(){
        return balance;
    }

    private AVLTree(int v){
        this.v = v;
    }

    private void calc_balance(){
        int lh = l == null? 0 : l.getHeight();
        int rh = r == null? 0 : r.getHeight();
        balance = lh - rh;
    }

    private int getHeight(){
        // 正常来说是 1, 这里为了打印
        int h = 2;
        int hl = l == null? 0 : l.getHeight();
        int hr = r == null? 0 : r.getHeight();
        return h + Math.max(hl, hr);
    }

    private int getWidth(){
        int w = ("" + v).length();
        if(l != null) w += l.getWidth();
        if(r != null) w += r.getWidth();
        return w;
    }

    private AVLTree add(AVLTree newTree){
        AVLTree root = this;
        if(newTree.v < v){
            if(l == null) l = newTree;
            else l.add(newTree);
        }else{
            if(r == null) r = newTree;
            else r.add(newTree);
        }

        calc_balance();

        // 如果左边重了
        if(balance > 2){
            // 如果还是左边重，那么就是LL型
            if(l.getBalance() > 0){
                root = adjustLL();
            }else{
                // LR型
                root = adjustLR();
            }
        }

        if(balance < -2){
            if(r.getBalance() < 0){
                // RR
                root = adjustRR();
            }else {
                // RL
                root = adjustRL();
            }
        }

        calc_balance();
        return root;
    }

    private AVLTree adjustLL() {
        // 把 左子树的右子树 加到 左边
        if(l.r != null) l = l.r;
        // 把左子树作为根
        AVLTree root = l;
        // 把自己变为新根的右子树
        root.r = this;
        return root;
    }

    private AVLTree adjustRR() {
        AVLTree root = r;
        r = root.l;
        root.l = this;
        return root;
    }

    private AVLTree adjustLR(){
        l = l.adjustRR();
        return adjustLL();
    }

    private AVLTree adjustRL(){
        r = r.adjustLL();
        return adjustRR();
    }

}
