import java.util.*;
public class BSTree<E extends Comparable<E>>
{
    private int size;
    private Node<E> root;

    private static class Node<E>
    {
        E val;
        Node<E> left;
        Node<E> right;
        
        Node()
        {
            val = null;
            left = null;
            right = null;
        }

        Node(E mVal)
        {
            val = mVal;
            left = null;
            right = null;
        }

        Node(E mVal, Node<E> mLeft, Node<E> mRight)
        {
            val = mVal;
            left = mLeft;
            right = mRight;
        }
    }

    BSTree()
    {
        clear();
    }

    /* ------------------------------------------------------------ */

    public void clear()
    {
        root = null;
        size = 0;
    }

    /* ------------------------------------------------------------ */

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    /* ------------------------------------------------------------ */

    public boolean add(E e) 
    {
        //addIterative(e);
        addRecursive(root, e);
        return true;
    }

    private Node<E> addRecursive(Node<E> root, E e)
    {
        if(root == null)
            return new Node<E>(e);
        
        if(e.compareTo(root.val) < 0) 
            root.left = addRecursive(root.left, e);
        else
            root.right = addRecursive(root.right, e);
        
        return root;
        
    }

    private boolean addIterative(E e)
    {
        Node<E> current = root;
        while(current != null)
        {
            if(e.compareTo(current.val) < 0)
            {
                if(current.left != null) 
                {
                    current = current.left;
                }
                else
                {
                    current.left = new Node<E>(e);
                    break;
                }
            }
            else
            {
                if(current.right != null) 
                {
                    current = current.right;
                }
                else
                {
                    current.left = new Node<E>(e);
                    break;
                }
            }    
        }
        
        
    }

    /* ------------------------------------------------------------ */

    public String toString()
    {
        return new Traverse<E>().inorder(root).toString();
    }

    /* ------------------------------------------------------------ */

    
    /* ------------------------------------------------------------ */


    private static class Traverse<E>
    {
        Node<E> root;

        Traverse()
        {
            root = null;
        }

        Traverse(Node<E> mRoot)
        {
            root = mRoot;
        }

        /* ------------------------------------------------------------ */

        public List<E> preorder(Node<E> root)
        {
            List<E> list = new LinkedList<E>();
            return preorderRecursive(root, list);
            //return preorderIterative(root, list);
        }

        public List<E> preorderRecursive(Node<E> root, List<E> list)
        {
            if(root == null)
                return list;

            list.add(root.val);
            preorderRecursive(root.left, list);
            preorderRecursive(root.right, list);

            return list;
        }

        public List<E> preorderIterative(Node<E> root, List<E> list)
        {
            Stack<Node<E>> s = new Stack<>();
            s.push(root);

            while(!s.isEmpty())
            {
                Node<E> node = s.pop();
                list.add(node.val);
                if(node.right != null) s.push(node.right);
                if(node.left != null) s.push(node.left);
            }

            return list;
        } 

        /* ------------------------------------------------------------ */

        public List<E> inorder(Node<E> root)
        {
            List<E> list = new LinkedList<E>();
            return inorderRecursive(root, list);
            //return inorderIterative(root, list);
        }

        public List<E> inorderRecursive(Node<E> root, List<E> list)
        {
            if(root == null)
                return list;

            inorderRecursive(root.left, list);
            list.add(root.val);
            inorderRecursive(root.right, list);

            return list;
        }

        public List<E> inorderIterative(Node<E> root, List<E> list)
        {
            Stack<Node<E>> s = new Stack<>();
            Node<E> curr = root;

            while(!s.isEmpty() || curr != null)
            {
                while(curr != null)
                {
                    s.push(curr);
                    curr = curr.left;
                }
                
                curr = s.pop();
                list.add(curr.val);
                curr = curr.right;
            }

            return list;
        }

        /* ------------------------------------------------------------ */

        public List<E> postorder(Node<E> root)
        {
            List<E> list = new LinkedList<E>();
            return postorderRecursive(root, list);
            //return postorderIterative(root, list);
        }

        public List<E> postorderRecursive(Node<E> root, List<E> list)
        {
            if(root == null)
                return list;

            postorderRecursive(root.left, list);
            postorderRecursive(root.right, list);

            return list;
        }

        public List<E> postorderIterative(Node<E> root, List<E> list)
        {
            Stack<Node<E>> s = new Stack<>();
            Node<E> curr = root;

            while(!s.isEmpty() || curr != null)
            {
                while(curr != null)
                {
                    s.push(curr);
                    curr = curr.left;
                }
                
                curr = s.pop();
                list.add(curr.val);
                curr = curr.right;
            }

            return list;
        }
    }
}

