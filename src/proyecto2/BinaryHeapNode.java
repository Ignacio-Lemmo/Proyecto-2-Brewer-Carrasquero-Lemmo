package proyecto2;

/**
 * @author Ignacio y Carlos
 */

import java.text.SimpleDateFormat;  
import java.util.Date;
public class BinaryHeapNode {
   
    //Atributos:
    private BinaryHeapNode father;
    private BinaryHeapNode leftSon;
    private BinaryHeapNode rightSon;
    private FileNode info;
    private int index;
    private float time;
    
    //Constructor:
    public BinaryHeapNode(FileNode data, float timer, int i){
        this.father = null;
        this.leftSon = null;
        this.rightSon = null;
        this.info = data;
        this.index = i;
        this.time = timer;
//        if(info.getUrgency() == true){
//            this.time = (timer + (info.getPriorityInt() * info.getSize()));
//        }
//        else if (info.getUrgency() == false){
//            this.time = (timer + (info.getSize() * 4));
//        }
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
    public float getTime(){
        return time;
    }
    
    //Establecer el tiempo.
    public void setTime(float newTime){
        this.time = newTime;
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
