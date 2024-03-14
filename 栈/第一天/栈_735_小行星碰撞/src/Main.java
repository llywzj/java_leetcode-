import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    static Stack<Integer> sk=new Stack<Integer>();
    public static void check(int flag,int i,int[] asteroids)
    {
        if(flag >0 && asteroids[i] <0)
        {
            System.out.println("flag的值: " + Math.abs(flag));
            System.out.println("下一个数的值: " + asteroids[i]);
            if(Math.abs(flag) > Math.abs(asteroids[i]))
            {
            }
            else if(Math.abs(flag) == Math.abs(asteroids[i]))
            {
                System.out.println("弹出  相等 " + sk.pop());
            }
            else
            {
                if(!sk.isEmpty())
                {
                    System.out.println("弹出  " + sk.pop());
                }
                if(sk.isEmpty())
                {
                    System.out.println(asteroids[i]);
                    sk.push(asteroids[i]);
                }
                else {
                    check(sk.peek(),i,asteroids);
                }



            }
        } else if (flag >0 && asteroids[i] <0)
        {
            sk.push(asteroids[i]);
        }
        else
        {
            System.out.println("弹入" + asteroids[i]);
            sk.push(asteroids[i]);
        }
    }
    public static int[] asteroidCollision(int[] asteroids) {

        sk.push(asteroids[0]);

        for(int i=1;i<asteroids.length;i++){
            if(sk.isEmpty())
            {
                System.out.println(asteroids[i]);
                sk.push(asteroids[i]);
                continue;
            }
            int flag = sk.peek();

            check(flag,i,asteroids);
        }
        int[] arr = new int[sk.size()];

        System.out.println("栈大小 : " + sk.size());
        int a = sk.size();
        for(int j = 0;j<a;j++)
        {
            System.out.println("j = " +  j);
            arr[a - j - 1] = sk.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] asteroids = {1,-2,-2,-2};
        int[] asteroid = asteroidCollision(asteroids);
        for (int i = 0; i < asteroid.length; i++) {
            System.out.println(asteroid[i]);
        }

    }
}