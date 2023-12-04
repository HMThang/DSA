package Lab11;

import java.util.Collection;
import java.util.List;

import java.util.*;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    public void add(E e) {
        if (root == null) {
            this.root = new BNode<>(e);
        } else {
            this.root.add(e);
        }
    }

    public int depth(E node) {
        if (root == null) {
            return -1;
        }
        return root.depth(node);
    }

    public int height() {
        if (root == null) {
            return -1;
        }
        return root.height();
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size();
    }

    public boolean contains(E e) {
        if (root == null) {
            return false;
        }
        return root.contains(e);
    }

    public E findMin() {
        if (root == null) {
            return null;
        }
        return root.findMin();
    }

    public E findMax() {
        if (root == null) {
            return null;
        }
        return root.findMax();
    }

    public boolean remove(E e) {
        if (root == null) {
            return false;
        }
        return root.remove(e);
    }

    public List<E> descendants(E data) {
        if (root == null) {
            return null;
        }
        return root.descendants(data);
    }

    public List<E> ancestors(E data) {
        if (root == null) {
            return null;
        }
        return root.ancestors(data);
    }
}