import org.opencv.core.*;

import java.awt.Graphics;

import javax.swing.*;

class MatPanel extends JPanel{
    
    public Mat mat;
    
    public void paint(Graphics g){
        g.drawImage(HelloCv.MatToBufferedImage(mat), 0, 0, this);
    }
}