/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe_special;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LabelImage extends JButton {

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        //this.image = image;
        ImageIcon img=(ImageIcon) image;
        i=img.getImage();
    }

 
    public Dimension getImageSize() {
        return imageSize;
    }

    public void setImageSize(Dimension imageSize) {
        this.imageSize = imageSize;
        repaint();
    }

    private Icon image=null;
    private Dimension imageSize = new Dimension(33,33);
    private Image i=null;
    public LabelImage() {
        this.setContentAreaFilled(false);
        this.setBorder(null);
        
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        int width = getWidth();
        int height = getHeight();
        int x = (width - imageSize.width) / 2;
        int y = (height - imageSize.height) / 2;
        g2.drawImage(i, x, y, imageSize.width, imageSize.height, null);
        g2.dispose();
        super.paintComponent(grphcs);
    }
}