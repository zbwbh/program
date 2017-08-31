package com.arithmetic.first;

import java.util.Arrays;

/**
 * 归并排序，书读百遍其义自见，代码也是一样的道理，刚开始看归并排序的时候这个懵逼啊，现在好多了
 * 归并排序伪代码：
 * MERGE(A,p,q,r)
 * n1 = q - p + 1
 * n2 = r - q
 * let L[1..n1 + 1] and R[1..n2 + 1]be new arrays
 * for i = 1 to n1
 *     L[i] = A[p + i -1]
 * for j = 1 to n2
 *     R[j] = A[q + j]
 * L[n1 + 1]=哨兵
 * R[n2 + 1]=哨兵
 * i = 1
 * j = 1
 * for k = p to r
 *     if L[i] <= R[j]
 *     A[k] = L[i]
 *     i = i + 1
 * else
 *     A[k] = R[j]
 *     j = j + 1
 * 这段伪代码包含了分解和合并，但是仅仅是一个方法是写不出算法的，还需要一个递归方法，但是递归我个人理解起来比较吃力，可能也是刚学的时候
 * 给自己留下阴影了吧，现在看看之前的阶乘递归还是能接受的，阶乘递归看下面的方法
 * 那么归并排序的边界条件呢？
 * @author koala
 * @since 2017年8月24日
 */
public class MergeSort {

    //递归阶乘，很明显的是他的边界条件是n=1
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    /**
     * 如果不参照伪代码，可以敲出来吗
     * 伪代码的第一个条件就是要有一个原始数组
     * //按照罗列扑克的方式思考这个方法，正如算法导论中写到的那样
     * @author koala
     * @since 2017年8月24日
     */
    public static void mergeArray(int arr[], int left, int mid, int right, int temp[]) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int k = 0;//中间数组序列指针
        while (i <= mid && j <= right) {//每一堆的当中牌的下标肯定不能超过当前堆牌的总数
            //分两种情况罗列两个堆中的牌，只要找到小的那个就罗列上去，与此同时，一旦要进行下一个牌的比较，那么拿出小牌之后的牌堆里的下标一定增加了一个
            //所以，哪个牌堆减少了，哪个牌堆的下标加一，而且，被罗列的牌堆（也就是新生成的牌堆）的下标一定是增加的，因为无论从哪个牌堆过来的都要新添加下一个进入的牌
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];//这里是为了将逻辑分开，好理解，所以将++的步骤写在了后面，每次叠加之后将下标向后移位
                k++;
                i++;
            }
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        
        //如果左牌堆里的牌都被罗列进temp里了，那么i一定是大于mid的，所以这个循环处理的情况就是左牌堆剩余的牌
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        
        //同理，这个处理的是右牌堆
        while(j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }
        
        //将k置零，并将新生成的与原数组等长的数组按照对应的元素下标将元素复制到原数组当中
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }
    
    /**
     * 递归方法，每次执行调用该方法，边界条件就是左下标小于右下标
     * 开始的时候按照他的代码执行顺序思考能稍微友好一些
     * 哎，没有强大的逻辑思维，但是仅仅把sort当做一个黑盒也能稍微知道点，但是没法透彻
     * 每次是先拆分，拆分完了在合并，因为不拆分之前都是无序的，所以将归并方法放在了最后，将左拆分和右拆分都放在了前面
     * 
     * @author koala
     * @since 2017年8月24日
     */
    public static void sort(int arr[], int left, int right, int temp[]){
        if (left < right) {
            int mid = (left + right)/2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            mergeArray(arr,left,mid,right,temp);
        }
    }
    
    public static void sort(int arr[]){
        int temp[] = new int[arr.length];//在排序前，先创建一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        //实际上整个归并排序是可以省略这个temp的，可以使用原始的arr，无非就是替换原数组的对应的下标正确位置的元素
        sort(arr,0,arr.length - 1,temp);
    }
    
    public static void main(String[] args) {
//        int result = factorial(5);
//        System.out.println(result);
        int arr[] = {4,6,8,1,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
