/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.dsa.cheatham;

/**
 *
 * @author novem
 */
    public class Rectangle extends GeometricObject
    {
        double length, width;

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
        
        public Rectangle(double length, double width)
        {
            this.length = length;
            this.width = width;
        }
        @Override
        public double getArea() {
            return length * width;
        }

        @Override
        public String toString() {
            return "Rectangle{" + "length=" + length + ", width=" + width + '}';
        }
        
    }
