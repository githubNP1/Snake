package Trial;

import java.util.*;

public class Full { //this class may not be actually necessary
    ArrayList<Segment> segments = new ArrayList<>();
    
    public Full(){
        segments.add(new Segment(100,100,110,110, "left"));
        segments.add(new Segment(110,100,120,110, "left"));
        segments.add(new Segment(120,100,130,110, "left"));
        segments.add(new Segment(130,100,140,110, "left"));
        segments.add(new Segment(140,100,150,110, "left"));
        segments.add(new Segment(150,100,160,110, "left"));
    }
    
    public void addSegment(){  //different ways of doing this  , have to make sure this method comes before direction change if last segment is on an anchor, these new segments need to have anchors as well
        String direction = segments.get(segments.size() - 1).direction;
        int x1 = segments.get(segments.size() - 1).pixels.get(0)[0];
        int y1 = segments.get(segments.size() - 1).pixels.get(0)[1];
        ArrayList<int[]> anchors = segments.get(segments.size() - 1).anchors;
        switch(direction){
            case "up":
                segments.add(new Segment(x1,y1 + 10,x1 + 10,y1 + 20, "up", anchors));
                break;
            case "down":
                segments.add(new Segment(x1,y1 - 10,x1 + 10,y1, "down", anchors));
                break;
            case "right":
                segments.add(new Segment(x1 - 10,y1,x1,y1 + 10, "right", anchors));
                break;
            default:
                segments.add(new Segment(x1 + 10,y1,x1 + 20,y1 + 10, "left", anchors));
                break;
        }
    }
}
