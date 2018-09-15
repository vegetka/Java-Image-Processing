import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.opencv.imgcodecs.Imgcodecs;

public class HelloCv {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat  hello = Mat.eye(3,3, CvType.CV_8UC1);
        System.out.println(hello.dump());
        do_still_captures(10,1,0);
    }

    static void do_still_captures(int frames, int lapse, int camera_id){
        VideoCapture camera = new VideoCapture(camera_id);
        camera.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 320);
        camera.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 240);
        Mat frame = new Mat();
        for(int i=0; i<frames; i++){
            if(camera.read(frame)){
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd --- hh-mm-ss");
                String omg = df.format(date);
                String filename = "video/" + omg + ".jpg";
                Imgcodecs.imwrite(filename, frame);
                try{
                    Thread.sleep(lapse*1000);
                }catch(Exception e){e.printStackTrace();}
            }
        }
        camera.release();
    }
}
