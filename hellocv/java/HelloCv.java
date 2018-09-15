import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import static org.opencv.imgcodecs.Imgcodecs.imwrite;

public class HelloCv {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat  hello = Mat.eye(150,150, CvType.CV_8UC1);
        hello.setTo(new Scalar(180,80,250));
        Mat sub = hello.submat(0,50,0,50);
        sub.setTo(new Scalar(0,0,100));
        imwrite("dev/hello.png", hello);
        System.out.println(hello.dump());
    }
}
