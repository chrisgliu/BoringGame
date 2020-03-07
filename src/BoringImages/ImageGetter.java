package BoringImages;
    import javax.imageio.ImageIO;
    import java.awt.*;
    import java.awt.geom.AffineTransform;
    import java.awt.image.AffineTransformOp;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
public class ImageGetter {
    //list all the images
    private BufferedImage error;
    private BufferedImage tank;
    private BufferedImage rtank;
    public ImageGetter(){
        //load in all the images
        try {// https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
            tank = ImageIO.read(getClass().getResource("/BoringImages/tank.png"));
            rtank = ImageIO.read(getClass().getResource("/BoringImages/rtank.png"));
            error = ImageIO.read(getClass().getResource("/BoringImages/error.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to retrieve images
    public BufferedImage getImage(int imgnum) {
        if (imgnum==0){
            return tank;
        }
        if (imgnum==1){
            return rtank;
        }
        return error;
    }
    //draw image
    public void DrawImage(Graphics window, int x, int y, int imgnum, int W, int H){
        Image img = getImage(imgnum).getScaledInstance(W, H, Image.SCALE_SMOOTH);;
        window.drawImage(img,x,y, null);
    }
    public void DrawRotatedImage(Graphics window, int x, int y, int imgnum, int W, int H, double rot){
        BufferedImage img = getImage(imgnum);
        double r = Math.toRadians(rot);
        double cx = W/2.0;
        double cy = H/2.0;
        AffineTransform tx = AffineTransform.getRotateInstance(r, cx, cy);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        Graphics2D g2d = (Graphics2D)window;
        g2d.drawImage(op.filter(img, null).getScaledInstance(W, H, Image.SCALE_SMOOTH), x, y, null);
    } //https://stackoverflow.com/questions/8639567/java-rotating-images
}
//importing classes https://stackoverflow.com/questions/28651061/how-to-import-my-own-class
