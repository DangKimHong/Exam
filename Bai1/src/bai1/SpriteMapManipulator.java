/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
class SpriteMapManipulator {
        public static void join(String inputPath, String outputPath, int dimesion) throws IOException {
        //mở file
        File directory = new File(inputPath);
        // lấy tất cả các file trong thư mục
        File[] files = directory.listFiles();

        //lấy thông tin của 1 hình nhỏ chiều rộng chiều cao
        BufferedImage sprite = ImageIO.read(files[0]);
        int width = sprite.getWidth() * dimesion;
        int height = sprite.getHeight() * dimesion;

        BufferedImage spriteMap = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = spriteMap.createGraphics();
        int x = 0;
        int y = 0;
        int _d = 0;
        for (File file : files) {
            sprite = ImageIO.read(file);
            if (_d == dimesion) {
                y += sprite.getHeight();
                x = 0;
                _d = 0;
            }
            g2d.drawImage(sprite, null, x, y);
            x += sprite.getWidth();
            _d++;
        }
        //ghi spriteMap
        ImageIO.write(spriteMap, "png", new File(outputPath));
    }
    
}
