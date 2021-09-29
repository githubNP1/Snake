package Trial;

import java.util.*;

public class Full {
    ArrayList<Segment> segments = new ArrayList<>();
    
    public Full(){
        segments.add(new Segment(100,100,110,110, "left"));
        segments.add(new Segment(110,100,120,110, "left"));
        segments.add(new Segment(120,100,130,110, "left"));
    }
}
