package com.cxf.leetcode.desginmodel;

public class Realizetype implements Cloneable {

    Realizetype() {
        System.out.println("创建原型类成功！");
    }

    /**
     * 实现Cloneable的clone方法实现浅拷贝，快速创建一个对象
     *
     * @return
     */
    @Override
    public Realizetype clone() {
        try {
            System.out.println("复制原型类成功！");
            return (Realizetype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Realizetype realizetype = new Realizetype();
        Realizetype realizetype2 = realizetype.clone();
        System.out.println(realizetype);
        System.out.println(realizetype2);
        System.out.println(realizetype == realizetype2);
        //创建原型类成功！
        //复制原型类成功！
        //com.cxf.leetcode.desginmodel.Realizetype@56ac3a89
        //com.cxf.leetcode.desginmodel.Realizetype@27c20538
        //false
    }
}
