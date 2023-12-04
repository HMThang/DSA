package Lab11;


import java.util.ArrayList;
import java.util.List;

class BNode<E extends Comparable<E>> {
    private E data;
    private BNode<E> left;
    private BNode<E> right;

    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void add(E e) {
        if (e.compareTo(this.data) < 0) {
            if (this.left == null) {
                this.left = new BNode<>(e);
            } else {
                this.left.add(e);
            }
        } else if (e.compareTo(this.data) > 0) {
            if (this.right == null) {
                this.right = new BNode<>(e);
            } else {
                this.right.add(e);
            }
        }
    }

    public int depth(E node) {
        return depthHelper(this, node, 0);
    }

    private int depthHelper(BNode<E> current, E node, int depth) {
        if (current == null) {
            return -1;
        }
        if (current.data.equals(node)) {
            return depth;
        }
        int leftDepth = depthHelper(current.left, node, depth + 1);
        int rightDepth = depthHelper(current.right, node, depth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }
        return rightDepth;
    }

    public int height() {
        return calculateHeight(this);
    }

    private int calculateHeight(BNode<E> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int size() {
        return calculateSize(this);
    }

    private int calculateSize(BNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + calculateSize(node.left) + calculateSize(node.right);
    }

    public boolean contains(E e) {
        return containsElement(this, e);
    }

    private boolean containsElement(BNode<E> node, E e) {
        int comp = e.compareTo(data);
        if (comp == 0) {
            return true;
        } else if (comp < 0) {
            return ((left == null) ? false : left.contains(e));
        } else {
            return ((right == null)) ? false : right.contains(e);
        }
    }

    public E findMin() {
        if (this.left == null) {
            return this.data;
        }
        return this.left.findMin();
    }

    public E findMax() {
        if (this.right == null) {
            return this.data;
        }
        return this.right.findMax();
    }

    public boolean remove(E e) {
        BNode<E> parent = null;
        BNode<E> current = this;
        boolean isLeftChild = false;

        while (current != null && !current.data.equals(e)) {
            parent = current;
            if (e.compareTo(current.data) < 0) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            return false;
        }

        if (current.left == null && current.right == null) {
            if (current == this) {
                this.data = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == this) {
                this.data = current.left.data;
                this.right = current.left.right;
                this.left = current.left.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == this) {
                this.data = current.right.data;
                this.left = current.right.left;
                this.right = current.right.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            BNode<E> successor = getSuccessor(current);
            if (current == this) {
                this.data = successor.data;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }
        return true;
    }

    private BNode<E> getSuccessor(BNode<E> node) {
        BNode<E> successorParent = node;
        BNode<E> successor = node;
        BNode<E> current = node.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    public List<E> descendants(E data) {
        List<E> descendantsList = new ArrayList<>();
        findDescendants(this, data, descendantsList);
        return descendantsList;
    }

    private void findDescendants(BNode<E> node, E data, List<E> descendantsList) {
        if (node == null) {
            return;
        }
        if (node.data.equals(data)) {
            addDescendants(node.left, descendantsList);
            addDescendants(node.right, descendantsList);
        } else if (data.compareTo(node.data) < 0) {
            findDescendants(node.left, data, descendantsList);
        } else {
            findDescendants(node.right, data, descendantsList);
        }
    }

    private void addDescendants(BNode<E> node, List<E> descendantsList) {
        if (node == null) {
            return;
        }
        descendantsList.add(node.data);
        addDescendants(node.left, descendantsList);
        addDescendants(node.right, descendantsList);
    }

    public List<E> ancestors(E e) {
        int comp = e.compareTo(data);
        List<E> re = new ArrayList<>();
        if (comp == 0) {
            return re;
        }
        if (left != null) {
            if (left.contains(e)) {
                re.addAll(left.ancestors(e));
                re.add(data);
            }
        }
        if (right != null) {
            if (right.contains(e)) {
                re.addAll(right.ancestors(e));
                re.add(e);
            }
        }
        return re;
    }
}
