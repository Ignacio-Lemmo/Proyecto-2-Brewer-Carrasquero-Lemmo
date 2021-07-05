package proyecto2;

import javax.swing.JOptionPane;

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
    
    //Establecer la raiz.
    public void setRoot(BinaryHeapNode newRoot){
        root = newRoot;
    }
    
    //Recoger el tamaño.
    public int getSize(){
        return size;
    }
    
    /**
     * Busca el nodo padre para saber la posición donde va a insertar el nuevo nodo
     * @param root
     * @param newNode
     * @return 
     */
    public BinaryHeapNode searchFather(BinaryHeapNode root, BinaryHeapNode newNode){
        BinaryHeapNode helper = null;
        if (root != null && root.getIndex() != Math.floor((newNode.getIndex()-1)/2)){
            if (helper == null){
                helper = searchFather(root.getLeftSon(), newNode);
            }
            if (helper == null){
                helper = searchFather(root.getRightSon(), newNode);
            }
            return helper;
        }
        return root;
    }
    
    /**
     * Encuentra el último nodo
     * @param root
     * @return 
     */
    public BinaryHeapNode searchLast(BinaryHeapNode root){
        BinaryHeapNode helper = null;
        if (root != null && root.getIndex() != size-1){
            if (helper == null){
                helper = searchLast(root.getLeftSon());
            }
            if (helper == null){
                helper = searchLast(root.getRightSon());
            }
            return helper;
        }
        return root;
    }
    
    /**
     * Añade un nodo
     * @param root
     * @param newNode 
     */  
    public void addNode(BinaryHeapNode root, BinaryHeapNode newNode){
        if (this.root == null){
            this.root = newNode;
            size ++;
        }
        else{
            BinaryHeapNode father = searchFather(this.root, newNode);
            if (father.getLeftSon() == null){
                father.setLeftSon(newNode);
                newNode.setFather(father);
                size ++;
                order2(newNode);
            }
            else if (father.getLeftSon() != null && father.getRightSon() == null){
                father.setRightSon(newNode);
                newNode.setFather(father);
                size ++;
                order2(newNode);
            }
        }
    }
    
    /**
     * Ordena el montículo después de agregado el nodo
     * @param newNode 
     */
    public void order2(BinaryHeapNode newNode){
        if (newNode.getFather() != null){
            if (newNode.getTime() < newNode.getFather().getTime()){
                FileNode info = newNode.getInfo();
                float time = newNode.getTime();
                newNode.setInfo(newNode.getFather().getInfo());
                newNode.setTime(newNode.getFather().getTime());
                newNode.getFather().setInfo(info);
                newNode.getFather().setTime(time);
                order2(newNode.getFather());
            }
        }
    }
    
    
    /**
     * Elimina el nodo más pequeño
     * @return retorna un nodo de tipo File Node para eliminarlo del montículo
     */
    public FileNode eraseMin2(){
        FileNode min = root.getInfo();
        if (root != null && root.getLeftSon() != null){
            BinaryHeapNode last = searchLast(this.root);
            BinaryHeapNode father = searchFather(this.root, last);
            if (father.getLeftSon() == last){
                last.getFather().setLeftSon(null);
            }
            else if (father.getRightSon() == last){
                last.getFather().setRightSon(null);
            }
            root.setInfo(last.getInfo());
            root.setTime(last.getTime());
            size --;
            swap2(this.root);
        }
        else if (root == null || root.getFather() == null || root.getLeftSon() == null){
            root = null;
        }
        return min;   
    }
    
    /**
     * Ordena el montículo después de eliminar el que tiene valor más pequeño
     * @param root 
     */
    public void swap2(BinaryHeapNode root){
        if (root.getRightSon() != null && root.getLeftSon() != null){
            BinaryHeapNode min = null;
            FileNode info = root.getInfo();
            float time = root.getTime();
            if (root.getRightSon().getTime() > root.getLeftSon().getTime()){
                min = root.getLeftSon();
                root.setInfo(min.getInfo());
                root.setTime(min.getTime());
                root.getLeftSon().setInfo(info);
                root.getLeftSon().setTime(time);
                swap2(root.getLeftSon());
            }
            else if (root.getRightSon().getTime() < root.getLeftSon().getTime()){
                min = root.getRightSon();
                root.setInfo(min.getInfo());
                root.setTime(min.getTime());
                root.getRightSon().setInfo(info);
                root.getRightSon().setTime(time);
                swap2(root.getRightSon());
            }
        }
        else if (root.getLeftSon() != null && root.getRightSon() == null){
            BinaryHeapNode min = null;
            FileNode info = root.getInfo();
            float time = root.getTime();
            if (root.getTime() > root.getLeftSon().getTime()){
                min = root.getLeftSon();
                root.setInfo(min.getInfo());
                root.setTime(min.getTime());
                root.getLeftSon().setInfo(info);
                root.getLeftSon().setTime(time);
                swap2(root.getLeftSon());
            }
        }
    }   
    
    /**
     * Busca el un nodo dentro del montículo. No se utiliza.
     * @param root
     * @param find
     * @return 
     */
    public BinaryHeapNode searchNode(BinaryHeapNode root, String find){
        BinaryHeapNode helper = null;
        if (root != null && !(root.getInfo().getTitle().equalsIgnoreCase(find))){
            if (helper == null){
                helper = searchNode(root.getLeftSon(), find);
            }
            if (helper == null){
                helper = searchNode(root.getRightSon(), find);
            }
            return helper;
        }
        return root;
    }
    
    /**
     * Imprimir inOrden. No se utiliza.
     * @param root
     * @param text
     * @return 
     */
    public String inOrderPrint(BinaryHeapNode root, String text){
        if (root != null){
            text += root.getInfo().getTitle() + ": " +  root.getInfo().getSize() + "\n";
            text = inOrderPrint(root.getLeftSon(), text);
            text = inOrderPrint(root.getRightSon(), text);
        }
        return text;
    }
    
    /**
     * Función que permite clonar el árbol para efectuar operaciones varias
     * @param toCopy
     * @param cloneHeap
     * @return 
     */
    public BinaryHeap clone (BinaryHeapNode toCopy, BinaryHeap cloneHeap){
        if (toCopy != null){
            BinaryHeapNode toAdd = new BinaryHeapNode(toCopy.getInfo(), toCopy.getTime(), toCopy.getIndex());
            cloneHeap.addNode(cloneHeap.getRoot(), toAdd);
            cloneHeap = clone(toCopy.getLeftSon(), cloneHeap);
            cloneHeap = clone(toCopy.getRightSon(), cloneHeap);
        }
        return cloneHeap;
    }
    
    /**
     * Elimina el nodo más pequeño
     * @return retorna un nodo de tipo File Node para eliminarlo del montículo
     */
    public BinaryHeapNode eraseMin1(){
        BinaryHeapNode min = root;
        if (root != null && root.getLeftSon() != null){
            BinaryHeapNode last = searchLast(this.root);
            BinaryHeapNode father = searchFather(this.root, last);
            if (father.getLeftSon() == last){
                last.getFather().setLeftSon(null);
            }
            else if (father.getRightSon() == last){
                last.getFather().setRightSon(null);
            }
            root.setInfo(last.getInfo());
            root.setTime(last.getTime());
            size --;
            swap2(this.root);
        }
        else if (root == null || root.getFather() == null || root.getLeftSon() == null){
            root = null;
        }
        InterfazInicial.hashTable.imprimir();
        JOptionPane.showMessageDialog(null, min.getInfo().getTitle() + min.getTime());
        return min;   
    }
    
    /**
     * Busca el un nodo dentro del montículo. No se utiliza.
     * @param root
     * @param find
     * @return 
     */
    public BinaryHeapNode searchIndex(BinaryHeapNode root, int find){
        BinaryHeapNode helper = null;
        if (root != null && !(root.getIndex() == find)){
            if (helper == null){
                helper = searchIndex(root.getLeftSon(), find);
            }
            if (helper == null){
                helper = searchIndex(root.getRightSon(), find);
            }
            return helper;
        }
        return root;
    }
//    //Ordenar nuevo nodo en arbol.
//    public void order (BinaryHeapNode newNode){
//        BinaryHeapNode helper = newNode;
//        if (newNode.getTime() < newNode.getFather().getTime()){
//            if (newNode.getFather().getFather() != null){
//                if (newNode.getFather().getFather().getLeftSon() == newNode.getFather()){
//                    if (newNode.getFather().getLeftSon() == newNode){
//                        newNode.setLeftSon(newNode.getFather());
//                        newNode.setFather(newNode.getFather().getFather());
//                        newNode.getFather().setLeftSon(newNode);;
//                        newNode.getLeftSon().setLeftSon(null);
//                        order(newNode);
//                    }
//                    else if (newNode.getFather().getRightSon() == newNode){
//                        newNode.setLeftSon(newNode.getFather().getLeftSon());
//                        newNode.setRightSon(newNode.getFather());
//                        newNode.setFather(newNode.getFather().getFather());
//                        newNode.getFather().setLeftSon(newNode);
//                        newNode.getRightSon().setLeftSon(null);
//                        newNode.getRightSon().setRightSon(null);
//                        order(newNode);                    
//                    }
//                }
//                else if (newNode.getFather().getFather().getRightSon() == newNode.getFather()){
//                    if (newNode.getFather().getFather().getLeftSon() == newNode.getFather()){
//                        if (newNode.getFather().getLeftSon() == newNode){
//                            newNode.setLeftSon(newNode.getFather());
//                            newNode.setFather(newNode.getFather().getFather());
//                            newNode.getFather().setRightSon(newNode);;
//                            newNode.getLeftSon().setLeftSon(null);
//                            order(newNode);
//                        }
//                        else if (newNode.getFather().getRightSon() == newNode){
//                            newNode.setLeftSon(newNode.getFather().getLeftSon());
//                            newNode.setRightSon(newNode.getFather());
//                            newNode.setFather(newNode.getFather().getFather());
//                            newNode.getFather().setRightSon(newNode);
//                            newNode.getRightSon().setLeftSon(null);
//                            newNode.getRightSon().setRightSon(null);
//                            order(newNode);                    
//                        }
//                    }
//                }
//            }
//            else if (newNode.getFather().getFather() == null){
//                if (newNode.getFather().getLeftSon() == newNode){
//                    newNode.getFather().setLeftSon(null);
//                    newNode.setLeftSon(newNode.getFather());
//                    newNode.setFather(null);
//                    order(newNode);
//                }
//                else if (newNode.getFather().getRightSon() == newNode){
//                    newNode.getFather().setRightSon(null);
//                    newNode.setLeftSon(newNode.getFather().getLeftSon());
//                    newNode.getFather().setLeftSon(null);
//                    newNode.setRightSon(newNode.getFather());
//                    newNode.setFather(null);
//                    order(newNode);
//                }
//            }
//        }
//    }
    
//    //Eliminar minimo.
//    public BinaryHeapNode eraseMin(){
//        BinaryHeapNode min = root;
//        if (root != null){
//            BinaryHeapNode last = searchLast(root);
//            BinaryHeapNode father = searchFather(root, last);
//            if (father.getLeftSon() == last){
//                father.setLeftSon(null);
//            }
//            else if (father.getRightSon() == last){
//                father.setRightSon(null);
//            }
//            last.setLeftSon(root.getLeftSon());
//            last.setRightSon(root.getRightSon());
//            root.getLeftSon().setFather(last);
//            root.getRightSon().setFather(last);
//            root = last;
//            root.setIndex(1);
//            size --;
//            swap(root);
//            
//        }
//        return min;
//    }
    
//    //Ordenar Nodo.
//    public void swap (BinaryHeapNode root){
//        BinaryHeapNode helper = root;
//        if (root != null && root.getLeftSon() != null){
//            if (root.getTime() > root.getLeftSon().getTime()){
//                if (root.getFather().getFather() == null){
//                    if (root.getRightSon() == null){
//                        if (root.getLeftSon().getLeftSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(helper.getLeftSon().getRightSon());
//                            swap(root);
//                        }
//                    }
//                    else if (root.getRightSon() != null){
//                        if (root.getLeftSon().getLeftSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(helper.getLeftSon().getRightSon());
//                            swap(root);
//                        }    
//                    }
//                }
//                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getLeftSon()){
//                    if (root.getRightSon() == null){
//                        if (root.getLeftSon().getLeftSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(helper.getLeftSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            swap(root);
//                        }
//                    }
//                    else if (root.getRightSon() != null){
//                        if (root.getLeftSon().getLeftSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(helper.getLeftSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            swap(root);
//                        }    
//                    }
//                }
//                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getRightSon()){
//                    if (root.getRightSon() == null){
//                        if (root.getLeftSon().getLeftSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(helper.getLeftSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }
//                    }
//                    else if (root.getRightSon() != null){
//                        if (root.getLeftSon().getLeftSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() == null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }
//                        else if (root.getLeftSon().getLeftSon() != null && root.getLeftSon().getRightSon() != null){
//                            root.setFather(root.getLeftSon());
//                            root.getFather().setLeftSon(root);
//                            root.getFather().setRightSon(root.getRightSon());
//                            root.setIndex(helper.getLeftSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getLeftSon().getLeftSon());
//                            root.setRightSon(helper.getLeftSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }    
//                    }
//                }
//            }
//        }
//        else if ((root != null && root.getRightSon() != null)){
//            if (root.getTime() > root.getRightSon().getTime()){
//                if (root.getFather().getFather() == null){
//                    if (root.getRightSon() == null){
//                        if (root.getRightSon().getLeftSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(helper.getRightSon().getRightSon());
//                            swap(root);
//                        }
//                    }
//                    else if (root.getRightSon() != null){
//                        if (root.getRightSon().getLeftSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setLeftSon(null);
//                            root.setRightSon(null);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(helper.getRightSon().getRightSon());
//                            swap(root);
//                        }    
//                    }
//                }
//                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getLeftSon()){
//                    if (root.getRightSon() == null){
//                        if (root.getRightSon().getLeftSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(helper.getRightSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            swap(root);
//                        }
//                    }
//                    else if (root.getRightSon() != null){
//                        if (root.getRightSon().getLeftSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setLeftSon(null);
//                            root.setRightSon(null);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(helper.getRightSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setLeftSon(root.getFather());
//                            swap(root);
//                        }    
//                    }
//                }
//                else if (root.getFather().getFather() != null && root.getFather() == root.getFather().getFather().getRightSon()){
//                    if (root.getRightSon() == null){
//                        if (root.getRightSon().getLeftSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            root.setLeftSon(null);
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            root.setRightSon(null);
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(helper.getRightSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }
//                    }
//                    else if (root.getRightSon() != null){
//                        if (root.getRightSon().getLeftSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setRightSon(null);
//                            root.setLeftSon(null);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() == null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setRightSon(null);
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }
//                        else if (root.getRightSon().getLeftSon() != null && root.getRightSon().getRightSon() != null){
//                            root.setFather(root.getRightSon());
//                            root.getFather().setRightSon(root);
//                            root.getFather().setLeftSon(root.getLeftSon());
//                            root.setIndex(helper.getRightSon().getIndex());
//                            root.getFather().setIndex(helper.getIndex());
//                            root.setLeftSon(helper.getRightSon().getLeftSon());
//                            root.setRightSon(helper.getRightSon().getRightSon());
//                            root.getFather().setFather(helper.getFather().getFather());
//                            root.getFather().getFather().setRightSon(root.getFather());
//                            swap(root);
//                        }    
//                    }
//                }
//            }
//        }
//    }  
}
