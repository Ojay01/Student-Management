package kingstech;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.HorizontalAlignment;

import java.net.MalformedURLException;

public class Logo {
    public static Image createWatermarkImage(String imagePath) {
        try {
            ImageData imageData = ImageDataFactory.create(imagePath);
            Image watermarkImage = new Image(imageData);
            watermarkImage.scaleToFit(50, 50);
            watermarkImage.setHorizontalAlignment(HorizontalAlignment.CENTER);
            return watermarkImage;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid image path: " + imagePath, e);
        }
    }
}
