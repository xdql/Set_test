import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * Created by ql on 2017/12/17.
 * 使用LinkedList存储一副扑克牌，然后实现洗牌功能，显示牌，52张，花色，点数。
 */
public class pocket {
    String huase;
    String nums;
    public static void main(String args[])
    {
        LinkedList list= (LinkedList) creatpocket();
      //  System.out.println(list);
        System.out.println("洗牌前");
        showpocket(list);
        shuffle(list);
        System.out.println();
        System.out.println("洗牌后");
        showpocket(list);
    }

    @Override
    public String toString() {
        return "{"+huase+nums+"}";
    }

    public static List creatpocket()
    {
        List list=new LinkedList();
        String []huase={"红桃","黑桃","方块","梅花"};
        String []nums={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int i=0;i<huase.length;i++)
        {
            for (int j=0;j<nums.length;j++)
            {
                list.add(new pocket(huase[i],nums[j]));
            }
        }

        return list;
    }
    //对list的遍历
    public static void showpocket(List list)
    {
        for (int i=0;i<list.size();i++)
        {
     //       String s=list.get(i);

            System.out.print(list.get(i).toString());
            if(i%10==9)
            {
                System.out.println();
            }
        }
        //Iterator iterator=list.iterator();

//        while(iterator.hasNext())
//        {
//            String s=iterator.next();
//
//        }
    }
    public  static void shuffle(LinkedList list)
    {
        //洗牌
        Random r=new Random();
        int i=0;
        while(i<100) {
        int index1=r.nextInt(list.size());
        int index2=r.nextInt(list.size());


            pocket p1 = (pocket) list.get(index1);
            pocket p2 = (pocket) list.get(index2);
            list.set(index1, p2);
            list.set(index2, p1);
            i++;
        }
    }
    public pocket(String huase,String nums)
    {
        this.huase=huase;
        this.nums=nums;
    }

    public String getHuase() {
        return huase;
    }

    public void setHuase(String huase) {
        this.huase = huase;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }




}
