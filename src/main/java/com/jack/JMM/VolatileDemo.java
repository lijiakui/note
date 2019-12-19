package com.jack.JMM;

import java.util.concurrent.TimeUnit;

/**
 * @author: LiJiakui
 * @Description: volatile 关键字 可见性演示
 * @Dat: Create in 15:02 2019-12-19
 * @Modifiled By:
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        seeVolatile();
    }

    /**
     * 验证 volatile关键字的可见性
     */
    private static void seeVolatile() {
        MyDemo myDemo = new MyDemo();
        //线程修改年龄
        new Thread(() -> {
            try {
                //休眠线程，更好的测试可见性
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myDemo.updateAge();
            System.out.println("线程休眠结束，修改当前年龄为:" + myDemo.age);
        },"AAA").start();

        //内存可见，所以当年龄修改成功后，可以看到最近的年龄不为0
        while (myDemo.age == 0) {
            //这里千万不要使用System.out.println输出内容
        }
        System.out.println("内存可见，年龄被修改，当前年龄:" + myDemo.age);
    }
}


class MyDemo{
    volatile int age = 0; //使用关键字 -> volatile 使内存可见
//    int age = 0;

    /**
     * 修改年龄为30
     */
    public void updateAge() {
        this.age = 30;
    }
}
