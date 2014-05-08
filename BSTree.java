/*
 * Michael Del Signore
 * 2/15/12
 */

public class BSTree
{
     private class BSTNode implements Comparable
     {
          BSTNode rc;
          BSTNode lc;
          Comparable data;
          
          public BSTNode()
          {
               data = null;
          }
          
          public BSTNode(Comparable o)
          {
               data = o;
          }
          
          public int compareTo(Object o)
          {
               return data.compareTo(o);
          }
     }
     
     private BSTNode root;
     
     public BSTree()
     {
          root = null;
     }
     
     public Object search(Comparable key)
     {
          if(key == null)
               return null;
          return search(root, key);
     }
     private Object search(BSTNode sr, Comparable key)
     {
          if(sr == null)
               return null;
          if(key.compareTo(sr.data) == 0)
               return sr.data;
          if(key.compareTo(sr.data) < 0)
               return search(sr.lc, key);
          return search(sr.rc, key);
     }
               
     public int height()
     {
          if(root == null)
               return 0;
          return height(root);
     }
     private int height(BSTNode sr)
     {
          if(sr == null)
               return 0;
          return 1 + Math.max(height(sr.lc),height(sr.rc));
     }
     
     public boolean add(Comparable o)
     {
          if(o == null)
               return false;
          root = add(root, o);
          return true;
     }
     private BSTNode add(BSTNode sr, Comparable o)
     {
          if(sr == null)
               return new BSTNode(o);
          if(o.compareTo(sr.data) < 0)
               sr.lc = add(sr.lc, o);
          else 
               sr.rc = add(sr.rc, o);
          return sr;
     }
     
     public BSTNode remove()//I was not sure which node the remove metho was supposed to return so I removed the min.  I also made removeMin and removeMax methods.
     {
          BSTNode ret = new BSTNode();
          return removeMin(root, ret);
     }
     
     public BSTNode removeMin()
     {
          BSTNode ret = new BSTNode();
          return removeMin(root, ret);
     }
     private BSTNode removeMin(BSTNode sr, BSTNode ret)
     {
          if(sr == null || ret == null)
               return null;
          if(sr.lc ==  null)
          {
               ret.data = sr.data;
               return sr.rc;
          }
          sr.lc = removeMin(sr.lc, ret);
          return sr;
     }
     
     public BSTNode removeMax()
     {
          BSTNode ret = new BSTNode();
          return removeMax(root, ret);
     }
     private BSTNode removeMax(BSTNode sr, BSTNode ret)
     {
          if(sr == null || ret == null)
               return null;
          if(sr.lc ==  null)
          {
               ret.data = sr.data;
               return sr.rc;
          }
          sr.lc = removeMax(sr.lc, ret);
          return sr;
     }
     //////////////////////////////////////////////////////////////////????????????
     public Object remove(Comparable key)
     {
          if(key == null || root == null)
               return null;
          BSTNode ret = new BSTNode();
          root = remove(root, key, ret);
          return ret.data;
     }
     private BSTNode remove(BSTNode sr, Comparable key, BSTNode ret)
     {
          if(sr == null)
               return null;
          if(key.compareTo(sr.data) < 0)
               sr.lc = remove(sr.lc, key, ret);
          else if(key.compareTo(sr.data) > 0)
               sr.rc = remove(sr.rc, key, ret);
          else
          {
               ret.data = sr.data;
               if(sr.lc == null)
                    return sr.rc;
               if(sr.rc == null)
                    return sr.lc;
               sr.data = null;
          }
          return sr;
     }
     
     public int size()
     {
          return size(root);
     }
     private int size(BSTNode sr)
     {
          if(sr == null)
               return 0;
          return 1 + (size(sr.lc) + size(sr.rc));
     }
     
     public void preOrder()
     {
          preOrder(root);
     }
     private void preOrder(BSTNode sr)
     {
          if(sr == null)
               return;
          System.out.print(sr.data + " ");
          preOrder(sr.lc);
          preOrder(sr.rc);
     }
     
     public void inOrder()
     {
          inOrder(root);
     }
     private void inOrder(BSTNode sr)
     {
          if(sr == null)
               return;
          inOrder(sr.lc);
          System.out.print(sr.data + " ");
          inOrder(sr.rc);
     }
     
     public void postOrder()
     {
          postOrder(root);
     }
     private void postOrder(BSTNode sr)
     {
          if(sr == null)
               return;
          postOrder(sr.lc);
          postOrder(sr.rc);
          System.out.print(sr.data + " ");
     }
}