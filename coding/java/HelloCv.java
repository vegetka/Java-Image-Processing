import org.opencv.core.Core;
import org.opencv.core.Mat;
import static java.lang.System.loadLibrary;
import static java.lang.System.out;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.MatOfInt;

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
        Mat submat = mat.submat(100,100,100,100);
        out.println(submat);
        out.println(mat);
        out.println("mat = " + mat.width() + " x " + mat.height() + " , " + mat.type());
        MatOfInt moi = new MatOfInt(Imgcodecs.CV_IMWRITE_PNG_COMPRESSION, 9);
        imwrite("images/output.png", submat);
    }
}
