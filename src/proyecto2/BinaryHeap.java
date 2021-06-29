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
    
    //Recoger la raiz.
    public BinaryHeapNode getRoot(){
        return root;
    }
    
    //Recoger el tamaño.
    public int getSize(){
        return size;
    }
    
    //Encontrar al padre.
    public BinaryHeapNode searchFather(BinaryHeapNode root, BinaryHeapNode newNode){
        BinaryHeapNode helper = root;
        if (root != null && helper.getIndex() != newNode.getIndex()%2){
            helper = searchFather(root.getLeftSon(), newNode);
            helper = searchFather(root.getRightSon(), newNode);
        }
        return helper;
    }
    
    //Encontrar el ultimo Nodo.
    public BinaryHeapNode searchLast(BinaryHeapNode root){
        BinaryHeapNode helper = root;
        if (root != null && helper.getIndex() != size){
            helper = searchLast(root.getLeftSon());
            helper = searchLast(root.getRightSon());
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
        BinaryHeapNode helper = root;
        if (root != null && root.getLeftSon() != null){
            if (root.getTime() > root.getLeftSon().getTime()){
                if (root.getFather().getFather() == null){
                    if (root.getRightSon() == null){
                        if (root.getLeftSon().getLeftSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(helper.getLeftSon().getRightSon());
                            swap(root);
                        }
                    }
                    else if (root.getRightSon() != null){
                        if (root.getLeftSon().getLeftSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(helper.getLeftSon().getRightSon());
                            swap(root);
                        }    
                    }
                }
                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getLeftSon()){
                    if (root.getRightSon() == null){
                        if (root.getLeftSon().getLeftSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(helper.getLeftSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            swap(root);
                        }
                    }
                    else if (root.getRightSon() != null){
                        if (root.getLeftSon().getLeftSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(helper.getLeftSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            swap(root);
                        }    
                    }
                }
                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getRightSon()){
                    if (root.getRightSon() == null){
                        if (root.getLeftSon().getLeftSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(helper.getLeftSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }
                    }
                    else if (root.getRightSon() != null){
                        if (root.getLeftSon().getLeftSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }
                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
                            root.setFather(root.getLeftSon());
                            root.getFather().setLeftSon(root);
                            root.getFather().setRightSon(root.getRightSon());
                            root.setIndex(helper.getLeftSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getLeftSon().getLeftSon());
                            root.setRightSon(helper.getLeftSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }    
                    }
                }
            }
        }
        else if ((root != null && root.getRightSon() != null)){
            if (root.getTime() > root.getRightSon().getTime()){
                if (root.getFather().getFather() == null){
                    if (root.getRightSon() == null){
                        if (root.getRightSon().getLeftSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(helper.getRightSon().getRightSon());
                            swap(root);
                        }
                    }
                    else if (root.getRightSon() != null){
                        if (root.getRightSon().getLeftSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setLeftSon(null);
                            root.setRightSon(null);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(helper.getRightSon().getRightSon());
                            swap(root);
                        }    
                    }
                }
                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getLeftSon()){
                    if (root.getRightSon() == null){
                        if (root.getRightSon().getLeftSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(helper.getRightSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            swap(root);
                        }
                    }
                    else if (root.getRightSon() != null){
                        if (root.getRightSon().getLeftSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setLeftSon(null);
                            root.setRightSon(null);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(helper.getRightSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setLeftSon(root.getFather());
                            swap(root);
                        }    
                    }
                }
                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getRightSon()){
                    if (root.getRightSon() == null){
                        if (root.getRightSon().getLeftSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            root.setLeftSon(null);
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            root.setRightSon(null);
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(helper.getRightSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }
                    }
                    else if (root.getRightSon() != null){
                        if (root.getRightSon().getLeftSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setRightSon(null);
                            root.setLeftSon(null);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setRightSon(null);
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }
                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
                            root.setFather(root.getRightSon());
                            root.getFather().setRightSon(root);
                            root.getFather().setLeftSon(root.getLeftSon());
                            root.setIndex(helper.getRightSon().getIndex());
                            root.getFather().setIndex(helper.getIndex());
                            root.setLeftSon(helper.getRightSon().getLeftSon());
                            root.setRightSon(helper.getRightSon().getRightSon());
                            root.getFather().setFather(helper.getFather().getFather());
                            root.getFather().getFather().setRightSon(root.getFather());
                            swap(root);
                        }    
                    }
                }
            }
        }
    }
    
    //Imprimir Lista.
    public String inOrderPrint(BinaryHeapNode root, String text){
        if (root != null){
            text = inOrderPrint(root.getLeftSon(), text);
            text += root.getInfo().getTitle() + ": " +  root.getInfo().getSize() + "\n";
            text = inOrderPrint(root.getRightSon(), text);
        }
        return text;
    }
}
