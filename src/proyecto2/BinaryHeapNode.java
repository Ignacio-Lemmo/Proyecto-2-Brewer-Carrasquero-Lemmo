package proyecto2;

/**
 * @author Ignacio
 */
public class BinaryHeapNode {
   
    //Atributos:
    private BinaryHeapNode father;
    private BinaryHeapNode leftSon;
    private BinaryHeapNode rightSon;
    private FileNode info;
    private int index;
    private double time;
    
    //Constructor:
    public BinaryHeapNode(FileNode data, double timer, int i){
        this.father = null;
        this.leftSon = null;
        this.rightSon = null;
        this.info = data;
        this.index = i;
        if (data.getUrgency() == true){
            if (data.getPriorityInt() == 1){
                this.time = timer * 0.001;
            }
            else if (data.getPriorityInt() == 2){
                this.time = timer * 0.0001;
            }
            else if (data.getPriorityInt() == 3){
                this.time = timer * 0.00001;
            }
        }
    }
    
    //Recoger el padre.
    public BinaryHeapNode getFather(){
        return father;
    }
    
    //Establecer el padre.
    public void setFather(BinaryHeapNode newFather){
        this.father = newFather;
    }
    
    //Recoger el hijo derecho.
    public BinaryHeapNode getRightSon(){
        return rightSon;
    }
    
    //Establecer el hijo derecho.
    public void setRightSon(BinaryHeapNode newRightSon){
        this.rightSon = newRightSon;
    }
    
    //Recoger el hijo izquierdo.
    public BinaryHeapNode getLeftSon(){
        return leftSon;
    }
    
    //Establecer el hijo izquierdo.
    public void setLeftSon(BinaryHeapNode newLeftSon){
        this.leftSon = newLeftSon;
    }
    
    //Recoger la info.
    public FileNode getInfo(){
        return info;
    }
    
    //Establecer la info.
    public void setInfo(FileNode newData){
        this.info = newData;
    }
    
    
    //Recoger el tiempo.
    public double getTime(){
        return time;
    }
    
    //Recoger el indice.
    public int getIndex(){
        return index;
    }
    
    //Establecer indice.
    public void setIndex(int i){
        this.index = i;
    }
}
