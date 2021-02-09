package ru.lnmo.render;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Vector {
    static double x1, y1;
    static double x2, y2;
    static double x3, y3;

    public Vector(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static void line(BufferedImage img, double x1, double y1, double x2, double y2) {
        if (x1 > x2) {
            for (double i = x2; i < x1; i++) {
                double y = (i - x1) / (x2 - x1) * (y2 - y1) + y1;
                System.out.println(x2 + " " + y2);
                img.setRGB((int) i, (int) y, new Color(118, 0, 0, 169).getRGB());
            }
        }
        if (x1 < x2) {
            for (double i = x1; i < x2; i++) {
                double y = (i - x1) / (x2 - x1) * (y2 - y1) + y1;
                img.setRGB((int) i, (int) y, new Color(118, 0, 0, 169).getRGB());
            }
        }
        if (x1 == x2) {
            if (y1 < y2) {
                for (double i = y1; i <= y2; i++) {
                    img.setRGB((int) x1, (int) i, new Color(118, 0, 0, 169).getRGB());
                }
            } else {
                for (double i = y2; i <= y1; i++) {
                    img.setRGB((int) x1, (int) i, new Color(118, 0, 0, 169).getRGB());
                }
            }
        }

    }


    public static void tangle(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3) {
        for (int x = 0; x <= Main.w; x++) {
            for (int y = 0; y < Main.h; y++) {
                double t = Math.signum((x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y));
                double v = Math.signum((x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y));
                double r = Math.signum((x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y));
                if (t == v && v == r && r == t) {
                    img.setRGB((int) x, (int) y, new Color(118, 0, 0, 169).getRGB());
                }
            }

        }
    }


    public static void tanglega(BufferedImage img, double x1, double y1, double x2, double y2, double x3, double y3,int n) {
        for (int x = 0; x <= Main.w; x++) {
            for (int y = 0; y < Main.h; y++) {
                double alpha= ((x-x1) * (y3-y1) - (x3-x1)* (y-y1)) /  ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
                double beta=((x2-x1) * (y-y1) - (y2-y1) * (x-x1)) / ((x2-x1) * (y3-y1)-(x3-x1)*(y2-y1));
             /*   double t = Math.signum((x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y));
                double v = Math.signum((x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y));
                double r = Math.signum((x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y));*/
                if (alpha>=0 && beta >= 0 && alpha+beta<=1/*t==v && v==r && r==t*/) {
                    img.setRGB((int) x, (int) y, (new Color((int)(alpha*255*n)%255,(int)(beta*255)*n%255 ,(int) ((1-alpha-beta)*255*n)%255) ).getRGB());
                }
            }

        }
    }
}
