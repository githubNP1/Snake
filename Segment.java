package Trial;

import java.util.*;

public class Segment {
    ArrayList<int[]> pixels = new ArrayList<>();
    String direction;
    ArrayList<int[]> anchors = new ArrayList<>(); //1 - up, 2 - down, 3 - right, 4 - left
    
    public Segment(int x1, int y1, int x2, int y2, String direction){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                int[] coord = {i, j};
                pixels.add(coord);
            }
        }
        this.direction = direction;
    }
    
    public Segment(int x1, int y1, int x2, int y2, String direction, ArrayList<int[]> anchors){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                int[] coord = {i, j};
                pixels.add(coord);
            }
        }
        this.direction = direction;
        this.anchors = anchors;
    }
    
    public void adjust(int x, int y){
        for(int[] pixel : pixels){
            pixel[0] += x;
            pixel[1] += y;
        }
        //if(!anchors.isEmpty()){ //System.out.println(1);
        //    checkIfOnAnchor();
        //}
    }
    
    public void checkIfOnAnchor(){ 
        //System.out.println(pixels.get(0)[0] + " " +  anchors.get(0)[0] + " " +  pixels.get(0)[1] + " " + anchors.get(0)[1]);
        if(pixels.get(0)[0] == anchors.get(0)[0] && pixels.get(0)[1] == anchors.get(0)[1]){ //System.out.println(2);
            switch(anchors.get(0)[2]){
                case 1:
                    direction = "up";
                    break;
                case 2:
                    direction = "down";
                    break;
                case 3:
                    direction = "right";
                    break;
                default:
                    direction = "left";
                break;
            }
            anchors.remove(0);
        }
    }
}
