package proyecto2;

/**
 * @author Ignacio
 */
public class BinaryHeap {
    
    //Atributos:
    private BinaryHeapNode root;
    private int size;
    
    //Constructor:
    public BinaryHeap(){
        this.root = null;
        this.size = 0;
    }
    
    //Encontrar al padre.
    public BinaryHeapNode searchFather(BinaryHeapNode root, BinaryHeapNode newNode){
        BinaryHeapNode helper = root;
        if (root != null){
            while ((helper.getIndex()-1)%2 != newNode.getIndex())
                helper = searchFather(root.getLeftSon(), newNode);
                helper = root;
                helper = searchFather(root.getRightSon(), newNode);
        }
        return helper;
    }
    
    //Encontrar el ultimo Nodo.
    public BinaryHeapNode searchLast(BinaryHeapNode root){
        BinaryHeapNode helper = root;
        if (root != null){
            while (helper.getIndex() != size){
                helper = searchLast(root.getLeftSon());
                helper = root;
                helper = searchLast(root.getRightSon());
            }
        }
        return helper;
    }
    
    //Añadir un nodo.   
    public void addNode(BinaryHeapNode root, BinaryHeapNode newNode){
        if (this.root == null){
            this.root = newNode;
            size ++;
        }
        else{
            BinaryHeapNode father = searchFather(root, newNode);
            if (father.getLeftSon() == null){
                father.setLeftSon(newNode);
                newNode.setFather(father);
                size ++;
                order (newNode);
            }
            else if (father.getLeftSon() != null && father.getRightSon() != null){
                father.setRightSon(newNode);
                newNode.setFather(father);
                size ++;
                order(newNode);
            }
        }
    }
    
    //Ordenar nuevo nodo en arbol.
    public void order (BinaryHeapNode newNode){
        BinaryHeapNode helper = newNode;
        if (newNode.getTime() < newNode.getFather().getTime()){
            if (newNode.getFather().getFather() != null){
                if (newNode.getFather().getFather().getLeftSon() == newNode.getFather()){
                    if (newNode.getFather().getLeftSon() == newNode){
                        newNode.setLeftSon(newNode.getFather());
                        newNode.setFather(newNode.getFather().getFather());
                        newNode.getFather().setLeftSon(newNode);;
                        newNode.getLeftSon().setLeftSon(null);
                        order(newNode);
                    }
                    else if (newNode.getFather().getRightSon() == newNode){
                        newNode.setLeftSon(newNode.getFather().getLeftSon());
                        newNode.setRightSon(newNode.getFather());
                        newNode.setFather(newNode.getFather().getFather());
                        newNode.getFather().setLeftSon(newNode);
                        newNode.getRightSon().setLeftSon(null);
                        newNode.getRightSon().setRightSon(null);
                        order(newNode);                    
                    }
                }
                else if (newNode.getFather().getFather().getRightSon() == newNode.getFather()){
                    if (newNode.getFather().getFather().getLeftSon() == newNode.getFather()){
                        if (newNode.getFather().getLeftSon() == newNode){
                            newNode.setLeftSon(newNode.getFather());
                            newNode.setFather(newNode.getFather().getFather());
                            newNode.getFather().setRightSon(newNode);;
                            newNode.getLeftSon().setLeftSon(null);
                            order(newNode);
                        }
                        else if (newNode.getFather().getRightSon() == newNode){
                            newNode.setLeftSon(newNode.getFather().getLeftSon());
                            newNode.setRightSon(newNode.getFather());
                            newNode.setFather(newNode.getFather().getFather());
                            newNode.getFather().setRightSon(newNode);
                            newNode.getRightSon().setLeftSon(null);
                            newNode.getRightSon().setRightSon(null);
                            order(newNode);                    
                        }
                    }
                }
            }
            else if (newNode.getFather().getFather() == null){
                if (newNode.getFather().getLeftSon() == newNode){
                    newNode.getFather().setLeftSon(null);
                    newNode.setLeftSon(newNode.getFather());
                    newNode.setFather(null);
                    order(newNode);
                }
                else if (newNode.getFather().getRightSon() == newNode){
                    newNode.getFather().setRightSon(null);
                    newNode.setLeftSon(newNode.getFather().getLeftSon());
                    newNode.getFather().setLeftSon(null);
                    newNode.setRightSon(newNode.getFather());
                    newNode.setFather(null);
                    order(newNode);
                }
            }
        }
    }
    
    //Eliminar minimo.
    public BinaryHeapNode eraseMin(){
        BinaryHeapNode min = root;
        if (root != null){
            BinaryHeapNode last = searchLast(root);
            BinaryHeapNode father = searchFather(root, last);
            if (father.getLeftSon() == last){
                father.setLeftSon(null);
            }
            else if (father.getRightSon() == last){
                father.setRightSon(null);
            }
            last.setLeftSon(root.getLeftSon());
            last.setRightSon(root.getRightSon());
            root.getLeftSon().setFather(last);
            root.getRightSon().setFather(last);
            root = last;
            root.setIndex(1);
            size --;
            swap(root);
            
        }
        return min;
    }
    
    //Ordenar Nodo.
    public void swap (BinaryHeapNode root){
        if (root != null && root.getLeftSon() != null){
            if (root.getTime() > root.getLeftSon().getTime()){
                if (root.getRightSon() == null){
                    
                }
                else if(root.getRightSon() != null){
                    
                }
            }
        }
        else if ((root != null && root.getRightSon() != null)){
            if (root.getTime() > root.getRightSon().getTime()){
                
            }
        }
    }
}
