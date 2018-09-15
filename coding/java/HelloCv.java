import org.opencv.core.Core;
import org.opencv.core.Mat;
import static java.lang.System.loadLibrary;
import static java.lang.System.out;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.MatOfInt;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;
import org.opencv.core.Scalar;

import static org.opencv.core.CvType.CV_8UC1;
import static org.opencv.core.CvType.CV_8UC3;
import static org.opencv.core.CvType.CV_64FC3;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;


public class HelloCv {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat  mat1 = Mat.eye(3,3, CV_8UC1);
        out.println("mat1 = ");
        out.println(mat1.dump());

        Mat  mat2 = Mat.zeros(3,3, CV_8UC1);
        out.println("mat2 = ");
        out.println(mat2.dump());

        Mat  mat3 = Mat.ones(3,3, CV_8UC1);
        out.println("mat3 = ");
        out.println(mat3.dump());

        Mat  mat4 = Mat.zeros(1,1, CV_8UC3);
        out.println("mat4 = ");
        out.println(mat4.dump());

        Mat  mat5 = Mat.ones(3,3, CV_64FC3);
        out.println("mat5 = ");
        out.println(mat5.dump());

        //convert to greyscale
        //Mat mat = imread("images/cobh.jpg", Imgcodecs.IMREAD_GRAYSCALE);
        Mat mat = imread("images/cobh.jpg");
        Mat submat = mat.submat(100,250,100,250);
        Imgproc.blur(submat, submat, new Size(25.0, 25.0));
        out.println(submat);
        out.println(mat);
        out.println("mat = " + mat.width() + " x " + mat.height() + " , " + mat.type());
        MatOfInt moi = new MatOfInt(Imgcodecs.CV_IMWRITE_PNG_COMPRESSION, 9);
        imwrite("images/output.png", mat);

        Mat rubik = new Mat(200,300,CV_8UC3);
        setColors(mat, false, 1);
        setColors(mat, true, 0);
        Imgcodecs.imwrite("images/rubik.jpg", rubik);
       
    }

    static void setColors(Mat mat, boolean comp, int row){
        Scalar RED = new Scalar(0,0,255);
        Scalar GREEN = new Scalar(0,255,0);
        Scalar BLUE = new Scalar(255,0,0);
        Scalar CYAN = new Scalar(255,255,0);
        Scalar MAGENTA = new Scalar(255,0,255);
        Scalar YELLOW = new Scalar(0,255,255);
        for(int i=0; i<3; i++){
            Mat sub = mat.submat(row*100, row*100+100, i*100, i*100+100);
            if(comp){
                if(i==0) sub.setTo(RED);
                if(i==1) sub.setTo(GREEN);
                if(i==2) sub.setTo(BLUE);
            }else{
                if(i==0) sub.setTo(CYAN);
                if(i==1) sub.setTo(MAGENTA);
                if(i==2) sub.setTo(YELLOW);
            }
        }
    }
}
