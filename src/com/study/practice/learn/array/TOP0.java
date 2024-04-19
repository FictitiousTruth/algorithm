package com.study.practice.learn.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0
 * @Author 作者名
 * @Date 2024/4/18 9:53
 * @注释: 《从双倍数组中还原原始数组》
 *
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * <p>
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * 示例 2：
 * <p>
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * 示例 3：
 * <p>
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= changed.length <= 105
 * 0 <= changed[i] <= 105
 *
 */

public class TOP0 {


    /**
     * @param changed
     * @return 解题思路：
     * 1遍历原数组 统计每个元素出现的次数
     * 2将原数组从小到大排序
     * 3遍历排序后的数组
     * 3.1如果从统计map中 get得到的值为0 continue
     * 3.2如果get得到的值不是0 将map中的value-1 再去判断当前值的2倍是否存在数组中 如果存在将2倍的值减一 如果不存在直接返回空数组
     */
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        int[] result = new int[changed.length / 2];
        //排序
        Arrays.sort(changed);
        //统计每个元素以及出现的频率
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        //遍历原数组统计逻辑
        for (int i = 0; i < changed.length; i++) {
            Integer t = map.getOrDefault(changed[i], 0);
            //todo 这行代码是当时没有想到的
            if (t == 0) continue;
            map.put(changed[i], --t);

            Integer doubleNum = map.getOrDefault(changed[i] * 2, 0);
            if (doubleNum == 0) return new int[0];

            map.put(changed[i] * 2, --doubleNum);
            result[index++] = changed[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 0, 1};
        System.out.println(Arrays.toString(findOriginalArray(arr)));
    }


}
