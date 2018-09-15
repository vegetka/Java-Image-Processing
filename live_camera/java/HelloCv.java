import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.awt.image.*;
import javax.swing.*;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.opencv.imgproc.Imgproc;

public class HelloCv {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    
        MatPanel t  = new MatPanel();
        JFrame frame0 = new JFrame();
        frame0.getContentPane().add(t);
        //frame0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame0.setSize(320, 240);
        frame0.setVisible(true);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VideoCapture camera = new VideoCapture(0);
        camera.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 320);
        camera.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 240);
        Mat frame = new Mat();
        while(true){
            if(camera.read(frame)){
                // b/w cartoon effect 
                //Imgproc.cvtColor(frame,frame, Imgproc.COLOR_RGB2GRAY);
                //Mat target = new Mat();
                //Imgproc.Canny(frame, target, 100.0, 150.0, 3,true);
                //t.mat = target;
                t.mat = frame;
                t.repaint();
            }
        }
    }

    public static BufferedImage MatToBufferedImage(Mat frame){
        int type = 0;
        if(frame==null) return null;
        if(frame.channels() == 1){
            type = BufferedImage.TYPE_BYTE_GRAY;    
        }else if(frame.channels() == 3){
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
        WritableRaster raster = image.getRaster();
        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBuffer.getData();
        frame.get(0,0,data);
        return image;
    }
}
