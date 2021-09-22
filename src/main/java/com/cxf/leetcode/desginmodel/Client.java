package com.cxf.leetcode.desginmodel;

public class Client {

    //抽象产品接口
    public interface Produce {
    }

    //产品A具体实现
    public static class ProduceA implements Produce {
        ProduceA() {
            System.out.println("产品A被生成出来了！！！");
        }
    }

    //产品B具体实现
    public static class ProduceB implements Produce {
        ProduceB() {
            System.out.println("产品B被生成出来了！！！");
        }
    }

    //抽象工厂接口
    public interface AbstractFactory {
        public Produce markProduce();
    }

    //产品A子工厂具体实现
    public static class ProductAFactory implements AbstractFactory {

        @Override
        public Produce markProduce() {
            System.out.println("子工厂ProductAFactory开始创建产品ProduceA...");
            return new ProduceA();
        }
    }

    //产品B子工厂具体实现
    public static class ProductBFactory implements AbstractFactory {

        @Override
        public Produce markProduce() {
            System.out.println("子工厂ProductBFactory开始创建产品ProduceB...");
            return new ProduceB();
        }
    }


    public static void main(String[] args) {
        ProductAFactory productAFactory = new ProductAFactory();
        Produce produceA = productAFactory.markProduce();

        ProductBFactory productBFactory = new ProductBFactory();
        Produce produceB = productBFactory.markProduce();
        //子工厂ProductAFactory开始创建产品ProduceA...
        //产品A被生成出来了！！！
        //子工厂ProductBFactory开始创建产品ProduceB...
        //产品B被生成出来了！！！
    }
}
