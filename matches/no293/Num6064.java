package matches.no293;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 * <p>
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 * <p>
 * 返回不含特殊楼层的 最大 连续楼层数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bottom = 2, top = 9, special = [4,6]
 * 输出：3
 * 解释：下面列出的是不含特殊楼层的连续楼层范围：
 * - (2, 3) ，楼层数为 2 。
 * - (5, 5) ，楼层数为 1 。
 * - (7, 9) ，楼层数为 3 。
 * 因此，返回最大连续楼层数 3 。
 * 示例 2：
 * <p>
 * 输入：bottom = 6, top = 8, special = [7,6,8]
 * 输出：0
 * 解释：每层楼都被规划为特殊楼层，所以返回 0 。
 * <p>
 * <p>
 * 提示
 * <p>
 * 1 <= special.length <= 105
 * 1 <= bottom <= special[i] <= top <= 109
 * special 中的所有值 互不相同
 */
public class Num6064 {

    //time out
//    public int maxConsecutive(int bottom, int top, int[] special) {
//        HashSet<Integer> specialSet = new HashSet<>();
//        for (int s:special) {
//            specialSet.add(s);
//        }
//        int res = 0;
//        int finalRes = 0;
//        for(int i = bottom;i<=top;i++){
//            if(specialSet.contains(i)){
//                finalRes = Math.max(res,finalRes);
//                res = 0;
//            }else{
//                res++;
//            }
//        }
//        finalRes = Math.max(res,finalRes);
//        return finalRes;
//    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = 0;
        for (int spe : special) {
            res = Math.max(spe - bottom, res);
            bottom = spe + 1;
        }
        res = Math.max(top - bottom + 1, res);
        return res;
    }
}
